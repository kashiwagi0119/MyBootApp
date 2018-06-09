package com.tuyano.springboot;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class MyData implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 200, nullable = true)
	private String mail;

	@Column(nullable = true)
	private Integer age;

	@Column(nullable = true)
	private String memo;

	@ManyToOne
	private Room room;
	
	public MyData() {
		super();
	}
	
}
