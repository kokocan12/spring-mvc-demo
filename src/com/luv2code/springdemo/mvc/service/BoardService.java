package com.luv2code.springdemo.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.mvc.mapper.BoardMapper;
import com.luv2code.springdemo.mvc.vo.Board;

@Service
@Component
public class BoardService {
	
//	@Autowired
//	private BoardMapper boardMapper;
	
	public Board getBoard() {
		Board b = new Board();
		b.setTitle("홍길");
		b.setContent("동전");
		return b;
	}
}
