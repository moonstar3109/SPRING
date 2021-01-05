package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 빈으로 생성
@RequestMapping("/request")
public class RequestController {
	
	//req_ex01화면처리 메서드
	//void형 메서드는 들어온 요청경로 그대로 뷰리졸버로 값이 반환됩니다.
//	@RequestMapping("/request/req_ex01")
//	public void req_ex01() {
//		System.out.println("실행됨");
//	}
	
	
	//(get, post 방식 둘다 허용)
	@RequestMapping("/req_ex01")
	public String req_ex01() {
		
		return "request/req_ex01";
				
	}
	
	//basic1요청처리(get방식만 허용)
	@RequestMapping(value="/basic1" , method = RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1요청");
	}
	
	//basic2요청처리(Post방식만 허용)
	@RequestMapping(value="/baisc2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2요청");
	}
	
	@GetMapping("/basic3") //Spring 4버전에서 나온것
	//@RequestMapping(value="/basic1" , method = RequestMethod.GET)동일
	public void basic3() {
		System.out.println("basic3요청");
	}
	
	@PostMapping("/basic4")
	//@RequestMapping(value="/baisc2", method = RequestMethod.POST)동일
	public void basic4() {
		System.out.println("basic4요청");
	}
	
	//=============================요청 파라미터 처리하기=============================
	
	
	
	//req_ex02화면처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	
	//1st
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		return "request/req_ex02_result";
//	}
	
	//2nd
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam("age") String age,
//						@RequestParam(value="inter", required=false, defaultValue = "") ArrayList<String> list)
//						{
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(age);
//		
//		//필수가 아닌 파라미터일 경우에는 required = false옵션을 지정할 수 있습니다.
//		System.out.println(list.toString());
//		
//		
//		return "request/req_ex02_result";
//	}
	
	//3rd
	//커맨드객체를 사용하는 방법
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		
		return "request/req_ex02_result";
	}
	
	
	//req_quiz01 화면처리
		@RequestMapping("/req_quiz01")
		public String req_quiz01() {
			return "request/req_quiz01";
		}
	//req_quiz01_ok 화면처리
		@RequestMapping("/req_quiz01_ok")
		public String req_quiz01_ok() {
			return "request/req_quiz01_ok";
		}
	//req_quiz01_no 화면처리
			@RequestMapping("/req_quiz01_no")
			public String req_quiz01_no() {
				return "request/req_quiz01_no";
			}			

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(ReqVO vo) {
		String id = vo.getId();
		String pw = vo.getPw();
		if(id.equals("abc123") && pw.equals("xxx123") ) {
			return "request/req_quiz01_ok";
		} 
		return "request/req_quiz01_no";
	}
//	public String login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		if(id.equals("abc123") && pw.equals("xxx123")) {
//			return "request/req_quiz01_ok";
//		}else {
//			return "request/req_quiz01_no";
//		}
//		
//		
//		
//	}
//	
	
	
	
}
