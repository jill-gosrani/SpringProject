package com.helix.demo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.helix.demo.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

    @Query(value = "Select * from helix_employee.employee where emp_name=:name",nativeQuery = true)
    Optional<Employee> findByName(String name);

}
