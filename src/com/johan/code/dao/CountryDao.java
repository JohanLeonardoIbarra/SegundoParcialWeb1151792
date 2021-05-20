package com.johan.code.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.johan.code.model.Country;
import com.johan.code.model.Cyclist;
import com.johan.code.util.ConexionPostgreSql;

public class CountryDao implements Serializable, PaisDao{
	
	private ConexionPostgreSql conexion;
	private final String SQL_INSERT = "insert into country(id, name) Values(?,?);";
	private final String SQL_DELETE = "delete from country where id = ?;";
	private final String SQL_UPDATE = "update country SET id = ?, name = ? where id = ?;";
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Country objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Country> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country select(int id) {
		// TODO Auto-generated method stub
		return null;
	} 

}
