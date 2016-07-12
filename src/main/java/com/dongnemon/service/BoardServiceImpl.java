package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnemon.dao.BoardDAO;
import com.dongnemon.domain.BoardVO;
import com.dongnemon.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public void register(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}
	
	@Override
	public int cntPaging(Criteria cri) throws Exception {
		return dao.cntPaging(cri);
	}
}
