package com.dhz.forestry_law_kg_backend.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public long findAll() {
        Query query = new Query();
        long count_num = mongoTemplate.count(query, Law.class);
        return count_num;
    }

    public List<Law> findByName(String law_name) {
        Criteria criteria = Criteria.where("name").is(law_name);
        Query query = new Query(criteria);
        List<Law> list = mongoTemplate.find(query, Law.class);
        return list;
    }
}
