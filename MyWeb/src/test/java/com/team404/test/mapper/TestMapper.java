package com.team404.test.mapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.command.ReplyVO;
import com.team404.command.UserVO;
import com.team404.common.util.Criteria;

public interface TestMapper {
	
	public int insertTest(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> selectTest(Criteria cri);
	public UserVO login(UserVO vo);

}
