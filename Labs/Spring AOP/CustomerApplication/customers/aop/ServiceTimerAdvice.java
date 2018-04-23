package customers.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class ServiceTimerAdvice {
	/*@AfterReturning(pointcut="execution(*  customers.EmailSender.*(..))", returning="retValue") 	 
	public void tracemethod(JoinPoint joinpoint, String retValue) {
		System.out.println("method ="+joinpoint.getSignature().getName());
		System.out.println("return value ="+ retValue);
	}*/
	 /*@AfterReturning(
		      pointcut = "execution(* customers.EmailSender.*(..))",
		      returning= "result")
		   public void logAfterReturning(JoinPoint joinPoint, String result) {

			System.out.println("logAfterReturning() is running!");
			System.out.println("hijacked : " + joinPoint.getSignature().getName());
			System.out.println("Method returned value is : " + result);
			System.out.println("******");

		   }*/

	
	@Around("execution(* customers.EmailSender.*(..))")
	public Object time(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis(); 
		
		System.out.println("Time to execute save = " + totaltime);
				
		LocalDateTime today=LocalDateTime.now();
		DateTimeFormatter formatToday=DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'GMT' yyyy");

        System.out.println(today.format(formatToday) + " method = " + call.getSignature().getName() + 
        											   " address = " + call.getArgs()[0] +
        											   " message = " + call.getArgs()[1]);
		return retVal;
	}
}
