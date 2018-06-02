package com.tuyano.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.Item;
import com.tuyano.springboot.MyData;
import com.tuyano.springboot.Room;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
	
}

