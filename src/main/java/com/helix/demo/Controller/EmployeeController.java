package com.helix.demo.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.helix.demo.Entity.Employee;
import com.helix.demo.Json.EmployeeJson;
import com.helix.demo.Json.Message;
import com.helix.demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
@RequestMapping("/Emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("addEmpById")
    private @ResponseBody ResponseEntity<Message> addUserById(@RequestBody EmployeeJson employeeJson) {

        Message mess = new Message();
        mess= employeeService.addEmployeeById(employeeJson);
        if(mess.getStatusCode() == 400){
            return new ResponseEntity<Message>(mess, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Message>(mess, HttpStatus.OK);
        }
        
    }

    @PostMapping("addEmpByName")
    private @ResponseBody ResponseEntity<Message> addUserByName(@RequestBody EmployeeJson employeeJson) {

        Message mess = new Message();
        mess= employeeService.addEmployeeName(employeeJson);
        if(mess.getStatusCode() == 400){
            return new ResponseEntity<Message>(mess, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Message>(mess, HttpStatus.OK);
        }
    }
    //
    @GetMapping("{id}")
    private Employee addUserById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @GetMapping("getById")
    public @ResponseBody ResponseEntity<List<EmployeeJson>> getByid(@RequestParam(value="Id",required=true)long id){
        List<EmployeeJson> list=new ArrayList<EmployeeJson>();
        list=employeeService.findData(id);
        return new ResponseEntity<List<EmployeeJson>>(list,HttpStatus.OK);
    }

    @GetMapping("getAll")
    public @ResponseBody ResponseEntity<List<EmployeeJson>> getAll(){
        List<EmployeeJson> list=new ArrayList<EmployeeJson>();
        list=employeeService.findAll();
        return new ResponseEntity<List<EmployeeJson>>(list,HttpStatus.OK);
    }
    
    @PutMapping("update")
    private @ResponseBody ResponseEntity<Message> upddateUSer(@RequestBody EmployeeJson employeeJson) {

        Message mess = new Message();
        mess= employeeService.updateEmp(employeeJson);
        if(mess.getStatusCode() == 400){
            return new ResponseEntity<Message>(mess, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Message>(mess, HttpStatus.OK);
        }
    }

    @DeleteMapping("delete")
    public @ResponseBody ResponseEntity<Message> delteByID(@RequestParam(value="Id",required=true)long id){
        Message mess = new Message();
        mess= employeeService.deleteById(id);
        if(mess.getStatusCode() == 400){
            return new ResponseEntity<Message>(mess, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Message>(mess, HttpStatus.OK);
        }
        
    }
}
