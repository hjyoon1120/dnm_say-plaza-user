package com.dongnemon.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongnemon.dao.BoardDAO;
import com.dongnemon.domain.BoardVO;
import com.dongnemon.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		for (int i = 0; i < 100; i++) {

			board.setTitle("Create new Text_" + i);
			board.setContent("Insert new Content_" + i);
			board.setWriter("User" + i);
			dao.create(board);
		}
	}

	@Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정 테스트 ");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	@Test
	public void testList() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.list(cri);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());

		}
	}

}
