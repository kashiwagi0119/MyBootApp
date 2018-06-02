package com.tuyano.springboot;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyDataSpecifications {
    /**
     * 名前
     */
    public static Specification<MyData> nameLike(String name) {
    	return StringUtils.isEmpty(name) ? null : new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (StringUtils.right(name, 1).equals("%")) {
					return cb.like(root.get("name"), name);
				} else {
					return cb.like(root.get("name"), name + "%");
				}
            }
        };
    }

    
    public static Specification<MyData> nameSpecifications(Operator2Enum operator, String name) {
    	return StringUtils.isEmpty(name) ? null : new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	        	switch (operator) {
				case EQUAL:
					return cb.equal(root.get("name"), name);
				case LIKE:
					if (StringUtils.right(name, 1).equals("%")) {
						return cb.like(root.get("name"), name);
					} else {
						return cb.like(root.get("name"), name + "%");
					}
				case GE:
					return cb.greaterThanOrEqualTo(root.get("name"), name);
				case LE:
					return cb.lessThanOrEqualTo(root.get("name"), name);
				default:
					return null;
	        	}
            }
        };
    }
    public static Specification<MyData> nameSpecifications(Operator1Enum operator) {
    	return new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	        	switch (operator) {
				case ISNULL:
					return cb.isNull(root.get("name"));
				case ISNOTNULL:
					return cb.isNotNull(root.get("name"));
				default:
					return null;
	        	}
            }
        };
    }
    
    /**
     * 年齢 （数値はLIKE無し,return age == null ?）
     */
    public static Specification<MyData> ageSpecifications(Operator2Enum operator, Integer age) {
    	return age == null ? null : new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				switch (operator) {
				case EQUAL:
					return cb.equal(root.get("age"), age);
				case GE:
					return cb.ge(root.get("age"), age);
				case LE:
					return cb.le(root.get("age"), age);
				default:
					return null;
				}
			}
    	};
    }
    
    /**
     * 部屋（関連テーブルはJoinTypeがある）
     */
    public static Specification<MyData> roomSpecifications(Operator2Enum operator, Room room, JoinType joinType) {
    	return (room == null || StringUtils.isBlank(room.getName())) ? null : new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				switch (operator) {
				case EQUAL:
					return cb.equal(root.join("room", joinType).get("room.name"), room);
				case LIKE:
					if (StringUtils.right(room.getName(), 1).equals("%")) {
						return cb.like(root.join("room", joinType).get("name"), room.getName());
					} else {
						return cb.like(root.join("room", joinType).get("name"), room.getName() + "%");
					}
				case GE:
					return cb.greaterThanOrEqualTo(root.join("room", joinType).get("name"), room.getName());
				case LE:
					return cb.lessThanOrEqualTo(root.join("room", joinType).get("name"), room.getName());
				default:
					return null;
				}
			}
        };
    }
    
    public static Specification<MyData> itemSpecifications(Operator2Enum operator, String itemname, JoinType joinType) {
    	return (itemname == null) ? null : new Specification<MyData>() {
			private static final long serialVersionUID = 1L;
			@Override
            public Predicate toPredicate(Root<MyData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.join("room", joinType).join("item", joinType).get("itemname"), "アイテム2");
			}
        };
    }
    
}