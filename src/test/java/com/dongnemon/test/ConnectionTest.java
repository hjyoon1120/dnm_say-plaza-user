package com.dongnemon.test;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class ConnectionTest {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/dongnemon";
	private static final String USER = "root";
	private static final String PW = "admin";

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void testConnection() throws Exception {

		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {

			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDataSource() throws Exception {

		try (Connection con = ds.getConnection()) {

			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFactory(){
		
		System.out.println(sqlFactory);
		
	}
	
	@Test
	public void testSession()throws Exception{
		
		try(SqlSession session = sqlFactory.openSession()){
			
			System.out.println(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
