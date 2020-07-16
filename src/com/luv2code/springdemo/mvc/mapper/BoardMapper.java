package com.luv2code.springdemo.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.luv2code.springdemo.mvc.vo.Board;

@Mapper
public interface BoardMapper {
	
	public Board getBoard();
}
