package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	//quiz01, quiz02, quiz03 화면을 동시에 처리 
	//반환유형  void형으로 맞추고 맵핑값을 배열로 전달
	@RequestMapping({"/quiz01","/quiz02","/quiz03"})
	public void views() {}
	
	//quiz1
	@RequestMapping(value="/sendBirth", method=RequestMethod.POST)
	public String sendBirth(@ModelAttribute("info") Quiz01VO vo) {
		
		System.out.println(vo.getYear());
		return "quiz/quiz01_ok";
	}
	
	//quiz2
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email) {
		return "quiz/quiz02_ok";
	}
	
	//quiz3
	@RequestMapping(value="/join2",method=RequestMethod.POST)
	public String join2(
			@RequestParam(value="id", required=false, defaultValue="") String id,
			@RequestParam("pw") String pw,
			@RequestParam("pw_check") String pw_check,
			RedirectAttributes RA,
			Model model) {

		if(id.equals("")) {
			RA.addFlashAttribute("msg","아이디를 입력하세요");
			return "redirect:/quiz/quiz03";

		}else if(!(pw.equals(pw_check))) {

			RA.addFlashAttribute("msg","비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";

		}else {
			model.addAttribute("id", id);
			return "quiz/quiz03_ok";
		}//inner if


	}
}
