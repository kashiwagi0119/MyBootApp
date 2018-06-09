package com.tuyano.springboot;

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

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable = true)
	private List<MyData> myDatas;
	
	@ManyToOne
	private Item item;
	
	public Room() {
		super();
	}
	
}
