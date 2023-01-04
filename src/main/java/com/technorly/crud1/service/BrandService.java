package com.technorly.crud1.service;

import com.technorly.crud1.entity.Brand;
import com.technorly.crud1.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService{

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findBrandById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException
                                ("The brand with id " + id + " does not exist")
                );
    }

    @Override
    public Brand saveBrand(Brand brand) {
        if(!(brand.getName().length() < brand.BRAND_NAME_MAX_LENGTH))
            throw new IllegalStateException("Name length is greater than " + brand.BRAND_NAME_MAX_LENGTH);
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand brandInDB = findBrandById(brand.getId());
        brandInDB.setName(brand.getName());
        return brandRepository.save(brand);
    }

    @Override
    public String deleteBrandById(Integer id) {
        Brand brandInDB = findBrandById(id);
        String nm = brandInDB.getName();
        brandRepository.deleteById(id);
        return "The brand " + nm + " has been deleted";
    }


}
