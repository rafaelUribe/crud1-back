package com.technorly.crud1.service;

import com.technorly.crud1.entity.Car;

public interface ICarService {
    public Iterable<Car> findAllCars();

    public Car findCarById(Integer id);

    public Car saveCar(Car car);

    public Car updateCar(Car car);

    public String deleteCarById(Integer id);
}
