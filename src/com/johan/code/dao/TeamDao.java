package com.johan.code.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.johan.code.model.Country;
import com.johan.code.model.Team;
import com.johan.code.util.ConexionPostgreSql;

public class TeamDao implements Serializable, EquipoDao{

	private ConexionPostgreSql conexion;
	private final String SQL_INSERT = "insert into team(id, name, country) Values(?,?,?);";
	private final String SQL_DELETE = "delete from team where id = ?;";
	private final String SQL_UPDATE = "update team SET name = ?, country = ? where id = ?;";
	private final String SQL_SELECT_BY_ID = "select * from team where id = ?;";
	private final String SQL_SELECT_ALL = "select * from team;"; 
	
	 public TeamDao(){
		 this.conexion = ConexionPostgreSql.getConexion();
	 }
	
	@Override
	public void insert(Team objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_INSERT);
			preparedStatement.setString(1, objeto.getId());
			preparedStatement.setString(2, objeto.getName());
			preparedStatement.setString(3, objeto.getCountry());
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_DELETE);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Team objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_UPDATE);
			preparedStatement.setString(1, objeto.getName());
			preparedStatement.setString(2, objeto.getCountry());
			preparedStatement.setString(3, objeto.getId());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Team> selectAll() {
		List <Team> equipos = new ArrayList<Team>();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_ALL);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				Team u = new Team(rs.getString("id"), rs.getString("name"), rs.getString("country"));
				equipos.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}

	@Override
	public Team select(int id) {
		Team equipo = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				String identifier = rs.getString("id");
				String nombre = rs.getString("name");
				String pais = rs.getString("country");
				equipo = new Team(identifier, nombre, pais);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipo;
	}
	
}
