package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class TimeAdvice {
	// 쿼리 실행 시간이 궁금 할 때,,,,,,,,,,

	
	@Around( "execution(* org.zerock.service.*.*(..))") 
	public Object checkTime(ProceedingJoinPoint pjp) {
		
		Object result =null;
		
		//시간 기록
		long start = System.currentTimeMillis();
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("TOTAL: " + (end-start));
		
		return result;
	}
	

}
