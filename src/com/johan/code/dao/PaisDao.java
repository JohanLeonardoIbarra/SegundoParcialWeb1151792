package com.johan.code.dao;

import java.util.List;

import com.johan.code.model.Country;

public interface PaisDao{
	public void insert(Country objeto);
	public void delete(int id);
	public void update(Country objeto);
	public List<Country> selectAll();
	public Country select(int id);
}
