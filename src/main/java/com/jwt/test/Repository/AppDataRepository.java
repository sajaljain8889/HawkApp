package com.jwt.test.Repository;

import com.jwt.test.entity.AppData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AppDataRepository extends MongoRepository<AppData,String> {
    AppData findByName(String name);
}
