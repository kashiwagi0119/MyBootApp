package com.tuyano.springboot;

import static com.tuyano.springboot.MyDataSpecifications.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
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

	// repositoryで検索
	public List<MyData> findRepository(MyDataForm mydataForm) {
	    
	    return repository.findAll(Specification
    		.where(nameSpecifications(LIKE, mydataForm.getName()))
    		.and(nameSpecifications(ISNOTNULL))
    		.and(ageSpecifications(GE, mydataForm.getAgeFrom()))
    		.and(ageSpecifications(LE, mydataForm.getAgeTo()))
    		.and(roomSpecifications(LIKE, mydataForm.getRoom(), INNER))
    		,
//	    	new Sort(Sort.Direction.ASC, "id")
    		new Sort(Sort.Direction.ASC, "id").and(new Sort(Sort.Direction.ASC, "name"))
	    );
	    
//		MyData myDataa = new MyData();
//		myDataa.setId(4);
//		myDataa.setRoom(null);
//		Example<MyData> example = Example.of(myDataa);
//	    return repository.findAll(example);
	    
	    
	}
	
	// Criteriaで検索
	public List<MyData> findCriteria(String fstr) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.equal(root.get("name"), fstr));
		List<MyData> list = null;
		list = (List<MyData>) entityManager.createQuery(query).getResultList();
		return list;
		
	}
	
}
