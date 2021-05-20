package com.johan.code.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSql {
	private Connection con = null;
	private PreparedStatement preparedStatement;
	private static ConexionPostgreSql db;
	
	String host = "queenie.db.elephantsql.com";
	String base = "mnjgxshj";
	String url = "jdbc:postgresql://"+host+":5432/"+base;
	String usuario = "mnjgxshj";
	String pass = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	String driver = "org.postgresql.Driver";

	public ConexionPostgreSql() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url,usuario,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConexionPostgreSql getConexion(){
		if (db == null) {
			db = new ConexionPostgreSql();
		}
		return db;
	}
	
	public ResultSet query() throws SQLException{
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getConnection(){
		System.out.println("ok");
		return this.con;
	}
	public static void main(String[] args) {
		ConexionPostgreSql c = ConexionPostgreSql.getConexion();
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
}
