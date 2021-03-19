package com.cos.mybatisex01.repository;

import org.apache.ibatis.annotations.Mapper;

import com.cos.mybatisex01.model.beans.PanmaeBean;

@Mapper //인터페이스를  구현한 객체로 띄워주는것
public interface PanmaeRepository {
	public PanmaeBean findByIdAndJoin(int id);

}
