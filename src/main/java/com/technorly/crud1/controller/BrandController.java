package com.technorly.crud1.controller;

import com.technorly.crud1.entity.Brand;
import com.technorly.crud1.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin("http://localhost:4200")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping
    public ResponseEntity<Iterable<Brand>> getAllBrands (){
        return new ResponseEntity<Iterable<Brand>>(brandService.findAllBrands(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getBrandById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Brand>(brandService.findBrandById(id), HttpStatus.OK);
        }
        catch(IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addNewBrand(@RequestBody Brand brand){
        try {
            return new ResponseEntity<Brand>(brandService.saveBrand(brand), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateBrand(@RequestBody Brand brand){
        try {
            return new ResponseEntity<Brand>(brandService.updateBrand(brand), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<String>(brandService.deleteBrandById(id), HttpStatus.OK);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
