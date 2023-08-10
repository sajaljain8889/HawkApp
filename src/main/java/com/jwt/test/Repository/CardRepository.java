package com.jwt.test.Repository;

import com.jwt.test.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card,String> {
}
