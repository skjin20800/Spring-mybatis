package com.cos.mybatisex01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cos.mybatisex01.model.Product;

@Mapper //인터페이스를  구현한 객체로 띄워주는것
public interface ProductRepository {
	public void save(Product product);
	public void deleteById(int id);
	public void update(Product product);
	public List<Product> findAll();
	public Product findById(int id);
		
}
