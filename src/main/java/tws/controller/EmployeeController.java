package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.addEmployee(employee);
        return ResponseEntity.created(URI.create("/employees" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getOne(@PathVariable String id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = employeeMapper.selectOne(id);
        employeeDTO.setDesc(employee.getName() + employee.getName());
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateOne(
            @PathVariable String id,
            @RequestBody Employee employee
    ) {
        employeeMapper.updateOne(id, employee);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.insert(employee);

        return ResponseEntity.created(URI.create("/employees" + id)).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {
        employeeMapper.deleteOne(id);

        return ResponseEntity.ok().build();
    }

}
