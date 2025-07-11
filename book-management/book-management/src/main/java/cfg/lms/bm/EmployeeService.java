package cfg.lms.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRespository repo;

	public void initAction(String option) {
		switch (option) {
		case "a":
			repo.addEmployee("balu");
			break;
		case "b":
			repo.getEmployeeCount();

		}
	}

}
