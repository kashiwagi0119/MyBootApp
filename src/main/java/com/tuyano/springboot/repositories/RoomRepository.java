package com.tuyano.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.entity.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room> {
	
}

