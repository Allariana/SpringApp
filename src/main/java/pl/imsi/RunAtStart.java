package pl.imsi;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAtStart {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public RunAtStart(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@PostConstruct
	public void runAtStart() {
		
		Employee employee = new Employee();
		employee.setFirstName("Anna");
		employee.setLastName("Nowak");
		employee.setSalary(new BigDecimal("4500"));
		
		employeeRepository.save(employee);
		
		Iterable<Employee> anie = employeeRepository.findByfirstName("Anna");
		
		for(Employee e: anie) {
			System.out.println("w bazie danych są:" +e);
		}
	}
	
	
}
