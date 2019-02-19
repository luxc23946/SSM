 package hkd.luxc.handler;

import hkd.luxc.entities.Employee;
import hkd.luxc.service.DepartmentService;
import hkd.luxc.service.EmployeeService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/employee")
@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping("/emps")
	public String list(Map<String, List<Employee>> requestMap) {
		requestMap.put("emps", employeeService.getAll());
		return "list";
	}
	
	@RequestMapping(value="emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,
			Map<String, Object> requestMap) {
		requestMap.put("emp", employeeService.get(id));
		requestMap.put("depts", departmentService.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String input(Map<String, Object> requestMap) {
		requestMap.put("emp", new Employee());
		requestMap.put("depts", departmentService.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		employeeService.delete(id);
		return "redirect:/employee/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(@ModelAttribute(value="emp") Employee employee) {
		if(null==employee.getId()) {
			employeeService.save(employee);
		}
		employeeService.update(employee);
		return "redirect:/employee/emps";
	}
	
	
	@ModelAttribute
	public void getModel(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object>requestMap) {
		if(id!=null) {
			requestMap.put("emp", employeeService.get(id));
		}
		
	}
	
}
