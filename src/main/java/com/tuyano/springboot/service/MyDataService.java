package com.tuyano.springboot.service;

import static com.tuyano.springboot.MyDataSpecifications.itemSpecifications;
import static com.tuyano.springboot.MyDataSpecifications.nameLike;
import static com.tuyano.springboot.constant.Operator2Enum.LIKE;
import static javax.persistence.criteria.JoinType.INNER;
import static javax.persistence.criteria.JoinType.LEFT;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.MyDataForm;
import com.tuyano.springboot.entity.MyData;
import com.tuyano.springboot.repositories.MyDataRepository;

@Service
public class MyDataService {

	@Autowired
	MyDataRepository repository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Criteriaで検索
	public List<MyData> findCriteria(MyDataForm form) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
	    final List<Predicate> where = new ArrayList<>();
	    
	    root.fetch("room", JoinType.LEFT); // 関連エンティティを同時に取ってくるように指定
	    root.fetch("room", JoinType.LEFT).fetch("item", JoinType.LEFT); // 関連エンティティを同時に取ってくるように指定
	    
	    // 名前
	    if (StringUtils.isNotBlank(form.getName())) {
	        where.add(builder.equal(root.get("name"), form.getName()));
	    }
	    // 年齢From
	    if (form.getAgeFrom() != null) {
	    	where.add(builder.ge(root.get("age"), form.getAgeFrom()));
	    }
	    // 年齢To
	    if (form.getAgeTo() != null) {
	    	where.add(builder.le(root.get("age"), form.getAgeTo()));
	    }
	    // 部屋
		if (form.getRoom() != null && StringUtils.isNotBlank(form.getRoom().getName())) {
			where.add(builder.equal(root.join("room", LEFT).get("name"), form.getRoom().getName()));
		}
		// アイテム
		if (form.getItem() != null && StringUtils.isNotBlank(form.getItem().getItemName())) {
			where.add(builder.equal(root.join("room", LEFT).join("item", LEFT).get("itemName"), form.getItem().getItemName()));
		}
		
		// 条件１つなら以下でOK
//		query.select(root).where(builder.equal(root.get("name"), name));
//		query.select(root).where(builder.equal(root.join("room", INNER).join("item", INNER).get("itemName"), "アイテム1"));
	    
		query.where(where.toArray(new Predicate[where.size()]));
	    List<MyData> list = (List<MyData>) entityManager.createQuery(query).getResultList();
		return list;
		
	}
	
	// Specificationで検索 (Specificationsを用意しないと。。。)
	public List<MyData> findSpecification(MyDataForm form) {
		return repository.findAll(Specification
				.where(nameLike(form.getName()))
//    		.where(nameSpecifications(LIKE, form.getName()))
//    		.and(nameSpecifications(ISNOTNULL))
//    		.and(roomSpecifications(LIKE, form.getRoom(), INNER))
				.and(itemSpecifications(LIKE, "アイテム1", INNER))
				,
//	    	new Sort(Sort.Direction.ASC, "id")
//    		new Sort(Sort.Direction.ASC, "id").and(new Sort(Sort.Direction.ASC, "name"))
				new Sort(Sort.Direction.ASC, "room.item.itemName")
				);
	}
	
	// JPQLで検索 (NULLチェックを2回やらないといけない)
	@SuppressWarnings("unchecked")
	public List<MyData> findJPQL(MyDataForm form) {
		// ■JPQL 単一テーブル
		String jpql = "from MyData where 1=1";
		if (StringUtils.isNotBlank(form.getName())) {
			jpql = jpql + " and name = :name";
		}
		jpql = jpql + " order by id desc";
		Query query = entityManager.createQuery(jpql);
		if (StringUtils.isNotBlank(form.getName())) {
			query.setParameter("name", form.getName());
		}
		
//		// ■JPQL INNSERJOIN
//		String jpql = "select m from MyData m";
//		jpql = jpql + " inner join Room r";
//		jpql = jpql + "   on m.room = r.id ";
//		jpql = jpql + " inner join Item i";
//		jpql = jpql + "   on r.item = i.id";
//		jpql = jpql + " where 1=1";
//		if (form.getRoom().getItem() != null && StringUtils.isNotBlank(form.getRoom().getItem().getItemName())) {
//			jpql = jpql + " and i.itemName = :itemName";
//		}
//		jpql = jpql + " order by m.id desc";
//		Query query = entityManager.createQuery(jpql);
//		if (form.getRoom().getItem() != null && StringUtils.isNotBlank(form.getRoom().getItem().getItemName())) {
//			query.setParameter("itemName", form.getRoom().getItem().getItemName());
//		}
		
		List<MyData> list = query.getResultList();
		return list;
	}
	
	// SQLで検索 (MyData型ではなくObjectで帰ってきてエラーになる)
	@SuppressWarnings("unchecked")
	public List<MyData> findSQL(MyDataForm form) {
		String sql = "select * from MyData where 1=1";
		if (StringUtils.isNotBlank(form.getName())) {
			sql = sql + " and name = :name";
		}
		sql = sql + " order by id desc";
		Query query = entityManager.createNativeQuery(sql);  // createNativeQuery
		if (StringUtils.isNotBlank(form.getName())) {
			query.setParameter("name", form.getName());
		}
		List<MyData> list = query.getResultList();
		// エラー回避用
		list.clear();
		return list;
	}
	
}
