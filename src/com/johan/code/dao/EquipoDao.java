package com.johan.code.dao;

import java.util.List;

import com.johan.code.model.Team;

public interface EquipoDao{
	public void insert(Team objeto);
	public void delete(int id);
	public void update(Team objeto);
	public List<Team> selectAll();
	public Team select(int id);
}
