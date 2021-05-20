package com.johan.code.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.johan.code.model.Cyclist;
import com.johan.code.model.Team;
import com.johan.code.util.ConexionPostgreSql;

public class CyclistDao implements Serializable, BikeDao{

	private ConexionPostgreSql conexion;
	private final String SQL_INSERT = "insert into cyclist(name, email, birthdate, country, team) Values(?,?,?,?,?);";
	private final String SQL_DELETE = "delete from cyclist where id = ?;";
	private final String SQL_UPDATE = "update cyclist SET name = ?, email = ?, birthdate = ?, country = ?, team = ? where id = ?;";
	private final String SQL_SELECT_BY_ID = "select * from cyclist where id = ?;";
	private final String SQL_SELECT_ALL = "select * from cyclist;"; 
	
	 public CyclistDao(){
		 this.conexion = ConexionPostgreSql.getConexion();
	 }
	
	@Override
	public void insert(Cyclist objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_INSERT);
			preparedStatement.setString(1, objeto.getName());
			preparedStatement.setString(2, objeto.getEmail());
			preparedStatement.setDate(3, objeto.getBirthDate());
			preparedStatement.setString(4, objeto.getCountry());
			preparedStatement.setString(5, objeto.getTeam());
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
	public void update(Cyclist objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_UPDATE);
			preparedStatement.setString(1, objeto.getName());
			preparedStatement.setString(2, objeto.getEmail());
			preparedStatement.setDate(3, objeto.getBirthDate());
			preparedStatement.setString(4, objeto.getCountry());
			preparedStatement.setString(5, objeto.getTeam());
			preparedStatement.setInt(5, objeto.getId());
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cyclist> selectAll() {
		List <Cyclist> ciclistas = new ArrayList<Cyclist>();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_ALL);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				Cyclist u = new Cyclist(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getDate("birthdate"), rs.getString("country"), rs.getString("team"));
				ciclistas.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciclistas;
	}

	@Override
	public Cyclist select(int id) {
		Cyclist ciclista = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int identifier = rs.getInt("id");
				String nombre = rs.getString("name");
				String email = rs.getString("email");
				Date date = rs.getDate("birthdate");
				String pais = rs.getString("country");
				String team = rs.getString("team");
				ciclista = new Cyclist(identifier, nombre,email, date, pais, team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciclista;
	}

}
