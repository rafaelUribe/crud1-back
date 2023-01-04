package com.technorly.crud1.repository;

import com.technorly.crud1.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
