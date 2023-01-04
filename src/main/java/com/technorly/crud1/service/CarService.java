package com.technorly.crud1.service;

import com.technorly.crud1.entity.Car;
import com.technorly.crud1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public Iterable<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findById(id)
                .orElseThrow( () ->
                        new IllegalStateException
                                ("The car with the id " + id + " does not exist.")
                );
    }

    @Override
    public Car saveCar(Car car) {
        if(!(car.getName().length() < Car.CAR_NAME_MAX_LENGTH)){
            throw new IllegalStateException("Name length is greater than " + Car.CAR_NAME_MAX_LENGTH);
        }
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        Car carInDB = findCarById(car.getId());
        carInDB.setName(car.getName());
        return carRepository.save(car);
    }

    @Override
    public String deleteCarById(Integer id) {
        Car carInDB = findCarById(id);
        String nm = carInDB.getName();
        carRepository.deleteById(id);
        return "The car with the name " + nm + " has been deleted";
    }
}
