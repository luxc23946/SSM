package hkd.luxc.Test;

import hkd.luxc.dao.DepartmentMapper;
import hkd.luxc.dao.EmployeeMapper;
import hkd.luxc.entities.Department;
import hkd.luxc.entities.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MybatisMain {
	
	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSession sqlSession = null;
	
	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources
				.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void destory() {
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testGetDepartment(){
		DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
		System.out.println(departmentMapper.getDepartment(1));
	}
	
	@Test
	public void testGetDepartments(){
		DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
		System.out.println(departmentMapper.getDepartments());
	}
	
	
	@Test
	public void testSave(){
		Department department=new Department();
		department.setId(3);
		Employee employee=new Employee(null, "Jerry", "dd@ddd.com", 0, department);
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		employeeMapper.save(employee);
	}
	
	@Test
	public void testGetAll(){
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		List<Employee>emps=employeeMapper.getAll();
		System.out.println(emps);
	}

	
	
	@Test
	public void testGet(){
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		Employee employee=employeeMapper.get(2);
		System.out.println(employee);
	}
	
	
	@Test
	public void testDelete(){
		EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
		employeeMapper.delete(6); 
	}
	

}
