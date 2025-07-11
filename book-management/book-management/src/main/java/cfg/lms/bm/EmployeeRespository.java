
package cfg.lms.bm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRespository {
	@Autowired
	JdbcTemplate template;

	@Autowired
	NamedParameterJdbcTemplate namedTemplate;

	public void getEmployeeCount() {
		int count = template.queryForObject("select count(*) from employee", Integer.class);
		System.out.println("employee count: " + count);
	}

	public void getEmployees() {
		List<Employee> employees = template.query("select * from employee", new EmployeeRowMapper());
		for (Employee emp : employees) {
			System.out.println("Emp Id: "+emp.getEmpId() + "     Emp Name: " + emp.getEmpNm());
		}

	}

	public void getEmployee(String emplNm) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("empnm", emplNm);
		int empId = namedTemplate.queryForObject("select id from employee where name=:empnm", namedParameters,
				Integer.class);
		System.out.println("employee id: " + empId);
	}

	public void addEmployee(String emplNm) {
		int maxId = template.queryForObject("select max(id) from employee", Integer.class);

		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("id", maxId + 1);
		namedParams.addValue("empNm", emplNm);
		namedTemplate.update("insert into employee values(:id,:empNm)", namedParams);
		System.out.println("****** new employee inserted *******");

	}

	public void deleteEmployee(String emplNm) {
		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("empNm", emplNm);
		namedTemplate.update("delete from employee where name = :empNm", namedParams);
		System.out.println("****** employee deleted *******");
	}

}
