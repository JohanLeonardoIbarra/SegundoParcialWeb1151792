package com.johan.code.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.johan.code.model.Country;
import com.johan.code.model.Cyclist;
import com.johan.code.util.ConexionPostgreSql;

public class CountryDao implements Serializable, PaisDao{
	
	private ConexionPostgreSql conexion;
	private final String SQL_INSERT = "insert into country(id, name) Values(?,?);";
	private final String SQL_DELETE = "delete from country where id = ?;";
	private final String SQL_UPDATE = "update country SET name = ? where id = ?;";
	private final String SQL_SELECT_BY_ID = "select * from country where id = ?;";
	private final String SQL_SELECT_ALL = "select * from country;"; 
	
	 public CountryDao(){
		 this.conexion = ConexionPostgreSql.getConexion();
	 }
	
	@Override
	public void insert(Country objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_INSERT);
			preparedStatement.setString(1, objeto.getId());
			preparedStatement.setString(2, objeto.getName());
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
	public void update(Country objeto) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_UPDATE);
			preparedStatement.setString(2, objeto.getId());
			preparedStatement.setString(1, objeto.getName());
			
			conexion.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Country> selectAll() {
		List <Country> paises = new ArrayList<Country>();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_ALL);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				Country u = new Country(rs.getString("id"), rs.getString("name"));
				paises.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paises;
	}

	@Override
	public Country select(int id) {
		Country pais = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SQL_SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				String identifier = rs.getString("id");
				String nombre = rs.getString("name");
				pais = new Country(identifier, nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pais;
	} 

}
