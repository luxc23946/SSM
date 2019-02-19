package hkd.luxc.service;

import java.util.List;

import hkd.luxc.dao.EmployeeMapper;
import hkd.luxc.entities.Employee;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/**
	 * 可以进行批量操作
	 */
	@Autowired
	private SqlSession SqlSession;

	@Transactional
	public List<Employee> getAll() {;
		return employeeMapper.getAll();
	}

	@Transactional
	public Employee get(Integer id) {
		return employeeMapper.get(id);
	}

	@Transactional
	public void delete(Integer id) {
		employeeMapper.delete(id);
	}

	@Transactional
	public void save(Employee employee) {
		employeeMapper.save(employee);
	}

	public void update(Employee employee) {
		 employeeMapper.update(employee);
	}
	

}
