package com.softech.planebookingsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("planeDao")
public class PlaneDAO {
	

	private NamedParameterJdbcTemplate jdbc;

	public PlaneDAO(){
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Plane> getPlanes() {

		return jdbc.query("select * from Plane", new RowMapper<Plane>() {

			public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
				Plane plane = new Plane();

				plane.setPlaneId(rs.getInt("plane_id"));
				plane.setPlaneName(rs.getString("plane_name"));
				plane.setPlaneNo(rs.getString("plane_no"));
				plane.setPassengerSeat(rs.getString("passenger_seat"));

				return plane;
			}

		});
	}

	public boolean update(Plane Plane) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(Plane);

		return jdbc.update("update Plane set plane_name=:planeName, plane_no=:planeNo, passenger_seat=:passengerSeat where plane_id=:planeId", params) == 1;
	}

	public boolean create(Plane Plane) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(Plane);

		return jdbc.update("insert into Plane (plane_name, plane_no, passenger_seat) values (:planeName, :planeNo, :passengerSeat)", params) == 1;
	}

	@Transactional
	public int[] create(List<Plane> Planes) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(Planes.toArray());

		return jdbc.batchUpdate("insert into Plane (plane_id, plane_name, plane_no, passenger_seat) values (:planeId, :planeName, :planeNo, :passengerSeat)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from Plane where plane_id=:id", params) == 1;
	}

	public Plane getPlane(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from Plane where plane_id=:id", params, new RowMapper<Plane>() {

			public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
				Plane plane = new Plane();

				plane.setPlaneId(rs.getInt("plane_id"));
				plane.setPlaneName(rs.getString("plane_name"));
				plane.setPlaneNo(rs.getString("plane_no"));
				plane.setPassengerSeat(rs.getString("passenger_seat"));

				return plane;
			}

		});
	}
	
	public List<Plane> getRecent(){
		
		return jdbc.query( "SELECT * FROM plane p ORDER BY p.plane_id DESC LIMIT 1", new RowMapper<Plane>(){
			
			public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
				Plane plane = new Plane();

				plane.setPlaneId(rs.getInt("plane_id"));
				plane.setPlaneName(rs.getString("plane_name"));
				plane.setPlaneNo(rs.getString("plane_no"));
				plane.setPassengerSeat(rs.getString("passenger_seat"));

				return plane;
			}
		});
	}


}
