package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("board-service")
	private BoardService service;

	//화면구현
	@RequestMapping("/boardRegister")
	public void boardRegister() {}
	
	
	//폼태그처리
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		service.boardRegist(vo);
		
		return "/service/boardResult";
	}
	
	//리스트페이지로 이동
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		return "/service/boardList";
	}
	
	//리스트 삭제
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int index) {
		
		service.boardDelete(index);
		
		return "redirect:/service/boardList";
		
	}
	
}
