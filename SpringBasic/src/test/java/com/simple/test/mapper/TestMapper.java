package com.simple.test.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.BoardVO;

public interface TestMapper {
	//인터페이스의 이름과 동일한 이름의 구현 xml파일을 생성
	public String getTime(); //조회
//	public int insert(BoardVO vo); //추가
	public int insert(Map<String, String> map);//추가
	
	public ArrayList<BoardVO> getList(); //조회
	public BoardVO getListOne(int num); //pk를 통한 단일 조회
	public ArrayList<BoardVO> getListTwo(@Param("name")String name, @Param("title") String title);
	public int update(BoardVO vo); //수정
	public boolean delete(int num); //삭제
}
