package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.BoardVO;
import com.dongnemon.domain.Criteria;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public void uptReplyCnt(Integer bno, int amount) throws Exception;
	
	public void uptViewCnt(Integer bno) throws Exception;
}
