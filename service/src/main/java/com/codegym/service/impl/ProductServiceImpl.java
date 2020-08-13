package com.codegym.service.impl;

import com.codegym.dao.entity.Product;
import com.codegym.dao.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId) {
        return productRepository.findDistinctByCategory_CategoryIdAndDeleteFlagIsFalseOrderByBrand(categoryId);
    }

    @Override
    public Page<Product> findAllByDeleteFlagFalsePaging(Pageable pageable) {
        return productRepository.findAllByDeleteFlagFalse(pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, Pageable pageable) {
        return  productRepository.findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(categoryId, brandId, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndDeleteFlagIsFalse(categoryId, pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findByProductIdAndDeleteFlagFalse(id);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        product.setDeleteFlag(true);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> findAllProductByBrandIdList(List<Integer> brandIdList) {
        return productRepository.productFindByListBrand(brandIdList);
    }
}
