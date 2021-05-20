package com.johan.code.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
	private Integer id;
	private String name;
	private String email;
	private Date birthDate;
	private String country;
	private String team;
}
