package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.BoardVO;
import com.dongnemon.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void modify(BoardVO board) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;

}
