package com.technorly.crud1.controller;

import com.technorly.crud1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.technorly.crud1.entity.*;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Car>>getAllCars() {
        return new ResponseEntity<Iterable<Car>>(carService.findAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //localhost:8080/api/car/id
    @ResponseBody
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<Car>(carService.findCarById(id), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping //localhost:8080/api/car
    @ResponseBody
    public ResponseEntity<?> addNewCustomer(@RequestBody Car car) {
        try {
            //Saves the car and returns it with its new id
            return new ResponseEntity<Car>(carService.saveCar(car), HttpStatus.CREATED);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        try {
            return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}") //localhost:8080/api/car/id
    @ResponseBody
    public ResponseEntity<?> deleteCar(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<String>(carService.deleteCarById(id), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
