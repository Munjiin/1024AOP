package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.service.SampleService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleService service;
	
	@Test
	public void testAdd() throws Exception{
		
		log.info(service.doAdd("123", "456"));
				
	}
	
	@Test
	public void testMulti() {
		
		//String str = "지잉 동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 대한사람 대한으로 .....";
		String str = "지잉 대한사람 대한으로 .....";
		
		service.addMulti(str);
		
	}
	
	

}
