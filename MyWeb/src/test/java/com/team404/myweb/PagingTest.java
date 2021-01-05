package com.team404.myweb;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team404.command.FreeBoardVO;
import com.team404.command.ReplyVO;
import com.team404.command.UserVO;
import com.team404.common.util.Criteria;
import com.team404.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springconfig/DB-context.xml")
public class PagingTest {

	@Autowired
	private TestMapper testMapper;
	
//	@Test //테스트 데이터 insert
//	public void Test() {
//		
//		for(int i = 1; i <= 100; i++) {
//			FreeBoardVO vo = new FreeBoardVO();
//			vo.setTitle("aaa제목" + i);
//			vo.setWriter("aaa성자" + i);
//			vo.setContent("aaaa내용입니다" + i);
//			
//			testMapper.insertTest(vo);
//			
//		}
//		
//	}
	
	
//	@Test //데이터 조회 테스트
//	public void test2() {
//		
//		Criteria cri = new Criteria(); //1번페이지의 10개 데이터
////		Criteria cri = new Criteria(3, 10); //3번페이지의 10개 데이터
//		ArrayList<FreeBoardVO> list = testMapper.selectTest(cri);
//		
//		System.out.println(list.toString());
//	}

	@Test
	public void test3() {
		
		UserVO vo = new UserVO();
		vo.setUserId("kkk123");
		vo.setUserPw("aaa123");
		
		UserVO result = testMapper.login(vo);
		System.out.println(result);
	}
	
	
	
	
	
	
}
