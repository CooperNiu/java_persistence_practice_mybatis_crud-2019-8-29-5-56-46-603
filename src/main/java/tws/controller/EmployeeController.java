package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService employeeService;

//    @GetMapping()
//    public ResponseEntity<List<Employee>> queryEmployees (@RequestParam(required = false) String id ,@RequestParam(required = false) String name) {
//        List<Employee> list = employeeMapper.selectSome(id,name);
//        return ResponseEntity.ok(list);
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<EmployeeDto>> queryEmployeesDto (@RequestParam(required = false) String id , @RequestParam(required = false) String name) {
//        List<EmployeeDto> list = employeeService.selectSome(id,name);
//        return ResponseEntity.ok(list);
//    }
//
//    @PutMapping("")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
//        employeeMapper.updateOne(employee);
//        return ResponseEntity.ok(employee);
//    }
//
//    @DeleteMapping("")
//    public ResponseEntity<String> deleteEmployee(@RequestParam String id) {
//        employeeMapper.deleteOne(id);
//        return ResponseEntity.ok(id);
//    }

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeMapper.addEmploy(employee);
        return ResponseEntity.created(URI.create(URI.create("/employees")+employee.getId())).build();
    }

    @GetMapping("/page")
    public ResponseEntity<List<Employee>> queryEmployeesWithPage (@RequestParam Integer page ,@RequestParam Integer pageSize) {
        List<Employee> list = employeeService.selectWithPage(page,pageSize);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/name")
    public ResponseEntity<Employee> queryEmployees (@RequestParam String name) {
        Employee employee = employeeService.select(name);
        return ResponseEntity.ok(employee);
    }
}
