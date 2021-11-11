package com.example.demo;

import com.example.demo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.Queue;

@Service
@Transactional
@Slf4j
public class EmployeeService {

    private final Queue<Employee> employees = new LinkedList<>();

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Employee employee) {
        employees.add(employee);

        if (employees.size() % 5 == 0) {
            log.info("flush");
            entityManager.flush();
            entityManager.clear();
        }

        entityManager.persist(employee);
    }

}
