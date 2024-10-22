package com.finalgastos.gastosApi.repository;

import com.finalgastos.gastosApi.model.Ingreso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngresoRepository extends MongoRepository<Ingreso, String> {
}

