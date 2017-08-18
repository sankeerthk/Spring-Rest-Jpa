package io.jpa.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jpa.exception.BadRequestException;
import io.jpa.exception.NotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findOne(String id) {
		return employeeDao.findOne(id)
						  .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not exist "));
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		Optional<Employee> existing= employeeDao.findByEmail(employee.getEmail());
		if(existing.isPresent()){
			throw new BadRequestException("Employee with email "+ employee.getEmail() +" already exist");
		}
		return employeeDao.create(employee);
	}

	@Override
	@Transactional
	public Employee update(String id,Employee employee) {
		employeeDao.findOne(id)
				   .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not exist "));
		return employeeDao.update(employee);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee employee =employeeDao.findOne(id)
				  					  .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not exist "));
		employeeDao.delete(employee);
	}
}
