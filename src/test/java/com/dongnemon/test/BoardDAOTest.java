package com.dongnemon.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongnemon.dao.BoardDAO;
import com.dongnemon.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		board.setTitle("Create new Text");
		board.setContent("Insert new Content");
		board.setWriter("Writer");
		dao.create(board);
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
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
