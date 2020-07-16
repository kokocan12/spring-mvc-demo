package com.luv2code.springdemo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.service.BoardService;

@Controller
@Component
public class MainController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String showPage(Model d) {
		
		d.addAttribute("board", boardService.getBoard());
		
		return "main-menu";
	}
}
