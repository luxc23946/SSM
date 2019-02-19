package hkd.luxc.entities;


public class Department {

	private Integer id;
	private String deptName;

	public Department() {}
	
	public Department(int i, String deptName) {
		this.id = i;
		this.deptName = deptName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}

	
	
}
