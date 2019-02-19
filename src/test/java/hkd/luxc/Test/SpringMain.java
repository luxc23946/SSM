package hkd.luxc.Test;

/**
 * Spring ºØ≥… Mybatis ≤‚ ‘
 */
import hkd.luxc.entities.Employee;
import hkd.luxc.service.EmployeeService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	private AbstractApplicationContext ctx;
	private EmployeeService employeeService;
	
	@Before
	public void init(){
		this.ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	    this.employeeService=ctx.getBean(EmployeeService.class);
	}
	
	public void destory(){
		ctx.close();
	}
	
	
	@Test
	public void testService(){
		Employee employee=employeeService.get(2);
		System.out.println(employee);
	}
}
