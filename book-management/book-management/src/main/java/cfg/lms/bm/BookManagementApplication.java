package cfg.lms.bm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BookManagementApplication.class, args);
//		EmployeeRespository emp = context.getBean(EmployeeRespository.class);
//		emp.getEmployeeCount();
//		emp.getEmployee("vijay");
//		System.out.println();
//		System.out.println("****** Actual data  ******");
//		emp.getEmployees();
//		System.out.println();
//		emp.addEmployee("karthikeya");
//		emp.getEmployees();
//		System.out.println();
//		emp.deleteEmployee("karthikeya");
//		emp.getEmployees();
		
		
		
		EmployeeService service = context.getBean(EmployeeService.class);
		service.initAction("b");

		
	}
	

}
