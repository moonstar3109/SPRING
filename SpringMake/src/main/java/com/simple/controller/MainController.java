package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	public MainController() {
		System.out.println("������");
	
	}
	
	
	@RequestMapping("/") // /��û�� ������ �� �ش� �޼���� ����
	public String home() {
		
		System.out.println("�����");
		//�����ų �ڵ带 �ۼ�......
		
		
		//return "/WEB-INF/views/home.jsp";
		return "home";
	}
}
