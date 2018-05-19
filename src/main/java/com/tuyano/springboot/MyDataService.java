package com.tuyano.springboot;

import static com.tuyano.springboot.MyDataSpecifications.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.repositories.MyDataRepository;
import static com.tuyano.springboot.Operator1Enum.*;
import static com.tuyano.springboot.Operator2Enum.*;
import static javax.persistence.criteria.JoinType.*;

@Service
public class MyDataService {

	@Autowired
	MyDataRepository repository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<MyData> findMyDatas(MyDataForm mydataForm) {
	    return repository.findAll(Specification
	    		.where(nameSpecifications(LIKE, mydataForm.getName()))
	    		.and(nameSpecifications(ISNOTNULL))
	    		.and(ageSpecifications(GE, mydataForm.getAgeFrom()))
	    		.and(ageSpecifications(LE, mydataForm.getAgeTo()))
	    		.and( roomSpecifications(LIKE, mydataForm.getRoom(), INNER))
	    		);
		
//	    return repository.findAll(Specification
//	        .where(name(LIKE, mydataForm.getName()))
//	        .and(room(LIKE, mydataForm.getRoom().getName(), INNER))
//	    );
	}
	
}
