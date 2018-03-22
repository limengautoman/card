package servlet;

import org.junit.Test;

import dao.CardDao;

public class TestCase {
	@Test
	public void test7(){
		CardDao dao=new CardDao();
         System.out.println(dao.findAll());
		
		
	}
}
