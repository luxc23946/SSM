package hkd.luxc.dao;


import hkd.luxc.entities.Employee;

import java.util.List;



public interface EmployeeMapper {
	
	public void save(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee get(Integer id);
	
	public void delete(Integer id);

	public void update(Employee employee);
}
