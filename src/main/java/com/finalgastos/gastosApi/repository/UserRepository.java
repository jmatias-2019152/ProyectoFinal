package com.finalgastos.gastosApi.repository;

import com.finalgastos.gastosApi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}