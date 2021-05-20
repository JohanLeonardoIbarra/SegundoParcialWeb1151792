package com.johan.code.model;

import java.util.Date;

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
