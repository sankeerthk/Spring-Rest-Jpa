package io.jpa.employee;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createNamedQuery("employee.findAll", Employee.class);
		return query.getResultList();
	}

	@Override
	public Optional<Employee> findByEmail(String email) {
		TypedQuery<Employee> query = em.createNamedQuery("employee.findByEmail", Employee.class);
		query.setParameter("pemail", email);
		List<Employee> employees = query.getResultList();
		if (!employees.isEmpty()) {
			return Optional.of(employees.get(0));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Employee> findOne(String id) {
		return Optional.ofNullable(em.find(Employee.class, id));
	}

	@Override
	public Employee create(Employee employee) {
		em.persist(employee);
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		return em.merge(employee);
	}

	@Override
	public void delete(Employee employee) {
		em.remove(employee);
	}
}
