package com.tuyano.springboot;

import static com.tuyano.springboot.MyDataSpecifications.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		
		// 条件１つなら以下でOK
//		query.select(root).where(builder.equal(root.get("name"), name));
//		query.select(root).where(builder.equal(root.join("room", INNER).join("item", INNER).get("itemname"), "アイテム1"));
	    
		query.where(where.toArray(new Predicate[where.size()]));
	    List<MyData> list = (List<MyData>) entityManager.createQuery(query).getResultList();
		return list;
		
	}
	
	// Specificationで検索
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
				new Sort(Sort.Direction.ASC, "room.item.itemname")
				);
	}
	
	// JPQLで検索 (NULLチェックを2回やらないといけない)
	@SuppressWarnings("unchecked")
	public List<MyData> findJPQL(MyDataForm form) {
//		// ■JPQL 単一テーブル
//		String jpql = "from MyData where 1=1";
//		if (StringUtils.isNotBlank(form.getName())) {
//			jpql = jpql + " and name = :name";
//		}
//		jpql = jpql + " order by id desc";
//		Query query = entityManager.createQuery(jpql);
//		if (StringUtils.isNotBlank(form.getName())) {
//			query.setParameter("name", form.getName());
//		}
		
		// ■JPQL INNSERJOIN
		String jpql = "select m from MyData m";
		jpql = jpql + " inner join Room r";
		jpql = jpql + "   on m.room = r.id ";
		jpql = jpql + " inner join Item i";
		jpql = jpql + "   on r.item = i.id";
		jpql = jpql + " where 1=1";
		if (form.getRoom().getItem() != null && StringUtils.isNotBlank(form.getRoom().getItem().getItemname())) {
			jpql = jpql + " and i.itemname = :itemname";
		}
		jpql = jpql + " order by m.id desc";
		Query query = entityManager.createQuery(jpql);
		if (form.getRoom().getItem() != null && StringUtils.isNotBlank(form.getRoom().getItem().getItemname())) {
			query.setParameter("itemname", form.getRoom().getItem().getItemname());
		}
		
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
