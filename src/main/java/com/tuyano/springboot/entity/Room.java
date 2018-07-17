package com.tuyano.springboot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SuppressWarnings("serial")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;
	
	@OneToMany
	@Column(nullable = true)
	private List<MyData> myDatas;
	
	@ManyToOne
	private Item item;
	
	public Room() {
		super();
	}
	
}
