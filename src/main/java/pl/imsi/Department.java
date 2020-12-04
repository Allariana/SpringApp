package pl.imsi;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDept;
	private String deptName;
	private String job;
	
	@OneToMany(mappedBy = "department")
	Set<Employee> employees;

	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
		this.idDept = idDept;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [idDept=" + idDept + ", deptName=" + deptName + ", job=" + job + ", employees=" + employees
				+ "]";
	}

	
}
