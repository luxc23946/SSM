package hkd.luxc.dao;

import hkd.luxc.entities.Department;
import java.util.List;

public interface DepartmentMapper {
	
	public List<Department> getDepartments();
	
	public Department getDepartment(Integer id);
	
}
