package com.johan.code.dao;

import java.util.List;

import com.johan.code.model.Cyclist;

public interface BikeDao{
	public void insert(Cyclist objeto);
	public void delete(int id);
	public void update(Cyclist objeto);
	public List<Cyclist> selectAll();
	public Cyclist select(int id);
}
