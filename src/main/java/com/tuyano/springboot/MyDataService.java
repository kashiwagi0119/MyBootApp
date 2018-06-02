package com.tuyano.springboot;

import static com.tuyano.springboot.MyDataSpecifications.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<MyData> findRepository(MyDataForm myDataForm) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		
	    return repository.findAll(Specification
    		.where(nameLike(myDataForm.getName()))
//    		.where(nameSpecifications(LIKE, myDataForm.getName()))
//    		.and(nameSpecifications(ISNOTNULL))
//    		.and(ageSpecifications(GE, myDataForm.getAgeFrom()))
//    		.and(ageSpecifications(LE, myDataForm.getAgeTo()))
//    		.and(roomSpecifications(LIKE, myDataForm.getRoom(), INNER))
    		.and(itemSpecifications(LIKE, "アイテム1", INNER))
    		,
//	    	new Sort(Sort.Direction.ASC, "id")
//    		new Sort(Sort.Direction.ASC, "id").and(new Sort(Sort.Direction.ASC, "name"))
    		new Sort(Sort.Direction.ASC, "room.item.itemname")
	    );
	    
//		MyData myDataa = new MyData();
//		myDataa.setId(4);
//		myDataa.setRoom(null);
//		Example<MyData> example = Example.of(myDataa);
//	    return repository.findAll(example);
	    
	    
	}
	
	// Criteriaで検索
	public List<MyData> findCriteria(MyDataForm form) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		
	    final List<Predicate> where = new ArrayList<>();
	    
	    // 名前
	    if (StringUtils.isNotBlank(form.getName())) {
	        where.add(builder.equal(root.get("name"), form.getName()));
	    }
		
	    // アイテム
		if (form.getRoom().getItem() != null && StringUtils.isNotBlank(form.getRoom().getItem().getItemname())) {
			where.add(builder.equal(root.join("room", INNER).join("item", INNER).get("itemname"), form.getRoom().getItem().getItemname()));
		}
		
//		query.select(root).where(builder.equal(root.get("name"), name));
//		query.select(root).where(builder.equal(root.join("room", INNER).join("item", INNER).get("itemname"), "アイテム1"));
	    
	    
	    
		query.where(where.toArray(new Predicate[where.size()]));
	    List<MyData> list = (List<MyData>) entityManager.createQuery(query).getResultList();
		return list;
		
	}
	
}
