package com.technorly.crud1.service;

import com.technorly.crud1.entity.Brand;

public interface IBrandService {
    public Iterable<Brand> findAllBrands();

    public Brand findBrandById(Integer id);

    public Brand saveBrand(Brand brand);

    public Brand updateBrand(Brand brand);

    public String deleteBrandById(Integer id);
}
