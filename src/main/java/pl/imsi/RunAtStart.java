package pl.imsi;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class RunAtStart {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}



	@PostConstruct
	public void runAtStart() {
		Department department = new Department();
		department.setDeptName("Sales");
		department.setJob("Manager");
		departmentRepository.save(department);
		
		Department dep = new Department();
		dep.setDeptName("Human Resources");
		dep.setJob("Recruiter");
		departmentRepository.save(dep);
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
//		EntityManager entitymanager = emfactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setFirstName("Anna");
		employee.setLastName("Nowak");
		employee.setSalary(new BigDecimal("4500"));	
		employeeRepository.save(employee);
		
		Iterable<Employee> anie = employeeRepository.findByfirstName("Anna");
		
		for(Employee e: anie) {
			System.out.println("w bazie danych są:" +e);
		}
		
		Employee employee2 = new Employee();
		employee2.setDepartment(department);
		employee2.setFirstName("Jan");
		employee2.setLastName("Kowalski");
		employee2.setSalary(new BigDecimal("5000"));	
		employeeRepository.save(employee2);
		
		employeeRepository.delete(employee);
		departmentRepository.delete(dep);
		
		employee2.setFirstName("Piotr");
		employeeRepository.save(employee2);
		department.setJob("Seller");
		departmentRepository.save(department);
		
		Iterable<Employee> piotr = employeeRepository.findByfirstName("Piotr");
		
		for(Employee e: piotr) {
			System.out.println("w bazie danych są:" + e);
		}
		
//		Query query = em.createQuery("Select * from Employee e where last_name like 'K%'");
//		List<Employee> list = query.getResultList();
//		//List<Employee> list = null;
//		Query q=em.createQuery("Select * from Employee e where last_name like 'K%'");
//		list=q.getResultList();
//		for(Employee e: list) {
//			System.out.println("Pracownicy o nazwisku zaczynającym się na literę K: " + e.getFirstName());
//		}
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Employee_details" );  
//        EntityManager em = emf.createEntityManager();  
//        em.getTransaction().begin( );  
                  
//        Query query = em.createNamedQuery("find lastname");  
//        @SuppressWarnings("unchecked")  
//      List<Employee> list =query.getResultList();  
//        System.out.println("Employee Name :");  
//        for(Employee e:list) {  
//              
//           System.out.println(e.getLastName());                       
//        }  
              
//        em.close();  
        //emf.close();    
	}
	
	
}
