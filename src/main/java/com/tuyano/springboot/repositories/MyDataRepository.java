package com.tuyano.springboot.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.entity.MyData;

@Repository
public interface MyDataRepository  extends JpaRepository<MyData, Long>, JpaSpecificationExecutor<MyData>, QuerydslPredicateExecutor<MyData> {

	List<MyData> findByNameOrderByIdDesc(String name);

}

