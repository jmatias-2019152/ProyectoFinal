package com.finalgastos.gastosApi.repository;


import com.finalgastos.gastosApi.model.Gasto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GastoRepository extends MongoRepository<Gasto, String> {
}
