package hkd.luxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hkd.luxc.dao.DepartmentMapper;
import hkd.luxc.entities.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Transactional
	public List<Department> getDepartments() {
		return departmentMapper.getDepartments();
	}

}
