package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<EmployeeDto> selectSome(String id, String name) {
        List<Employee> employees = employeeMapper.selectSome(id,name);
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDto.concat();
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    public List<Employee> selectWithPage(Integer page, Integer pageSize) {
        return  employeeMapper.selectWithPage((page - 1)*pageSize,pageSize);
    }

    public Employee select(String name) {
        return employeeMapper.select(name);
    }
}
