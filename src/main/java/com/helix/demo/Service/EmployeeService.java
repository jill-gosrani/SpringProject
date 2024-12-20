package com.helix.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helix.demo.Entity.Employee;
import com.helix.demo.Json.EmployeeJson;
import com.helix.demo.Json.Message;
import com.helix.demo.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired 
    private EmployeeRepo employeeRepo;

    public Message addEmployeeById(EmployeeJson employeeJson) {
        
        Message mess = new Message();
        Optional<Employee> model = employeeRepo.findById(employeeJson.getId());
        if(model.isPresent()){
            mess.setMessage("Already Exsits");
            mess.setStatusCode(400);
        }else{
            Employee empModel = new Employee();
            empModel.setId(employeeJson.getId());
            empModel.setEmail(employeeJson.getEmail());
            // empModel.setMob_no(employeeJson.getMob_no());
            empModel.setMob_no(employeeJson.getMob_no());
            empModel.setJ_date(employeeJson.getJ_date());
            empModel.setName(employeeJson.getName());
            employeeRepo.save(empModel);
            mess.setMessage("Sucessufully added emplyee: "+employeeJson.getId());
            mess.setStatusCode(200);

        }
        return mess;
    }

    public Message addEmployeeName(EmployeeJson employeeJson) {
        Message mess = new Message();
        Optional<Employee> model = employeeRepo.findByName(employeeJson.getName());
        if(model.isPresent()){
            mess.setMessage("Already Exsits");
            mess.setStatusCode(400);
        }else{
            Employee empModel = new Employee();
            empModel.setId(employeeJson.getId());
            empModel.setEmail(employeeJson.getEmail());
            empModel.setMob_no(employeeJson.getMob_no());
            empModel.setJ_date(employeeJson.getJ_date());
            empModel.setName(employeeJson.getName());
            employeeRepo.save(empModel);
            mess.setMessage("Sucessufully added emplyee: "+employeeJson.getId());
            mess.setStatusCode(200);

        }
        return mess;
    }

    public Employee findById(long id) {
            return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found for ID: " + id));
    }

    public List<EmployeeJson> findData(long id) {
        List<EmployeeJson> employeeJsons = new ArrayList<EmployeeJson>();
        Optional<Employee> emp = employeeRepo.findById(id);
        if(emp.isPresent()){
            Employee e = emp.get();
            EmployeeJson empJson = new EmployeeJson();
            empJson.setName(e.getName());
            empJson.setEmail(e.getEmail());
            empJson.setId(e.getId());
            empJson.setJ_date(e.getJ_date());
            empJson.setMob_no(e.getMob_no());

            employeeJsons.add(empJson);
        }
        return employeeJsons;
    }

    public List<EmployeeJson> findAll() {
        List<EmployeeJson> employeeJsons = new ArrayList<EmployeeJson>();
        Collection<Employee> empCol = employeeRepo.findAll();
        for(Employee e : empCol){
            EmployeeJson empJson = new EmployeeJson();
            empJson.setName(e.getName());
            empJson.setEmail(e.getEmail());
            empJson.setId(e.getId());
            empJson.setJ_date(e.getJ_date());
            empJson.setMob_no(e.getMob_no());
            employeeJsons.add(empJson);

        }
        return employeeJsons;
    }

    public Message updateEmp(EmployeeJson employeeJson) {
        Message mess = new Message();
        Optional<Employee> emp = employeeRepo.findById(employeeJson.getId());
        if (emp.isPresent()){
            Employee e = emp.get();
            e.setEmail(employeeJson.getEmail());
            e.setName(employeeJson.getName());
            e.setJ_date(employeeJson.getJ_date());
            e.setMob_no(employeeJson.getMob_no());
            employeeRepo.save(e);

            mess.setMessage("Employee updates"+ employeeJson.getId());
            mess.setStatusCode(200);
        }else{
            mess.setMessage("Employee not present");
            mess.setStatusCode(400);
        }
        return mess;
    }

    public Message deleteById(long id) {
        Message mess = new Message();
        Optional<Employee> emp = employeeRepo.findById(id);
        if(emp.isPresent()){
            employeeRepo.deleteById(id);
            mess.setMessage("Employee deleted");
            mess.setStatusCode(200);
        }
        else{
            mess.setMessage("Employee not present");
            mess.setStatusCode(400);
        }
        return mess;
    }

}
