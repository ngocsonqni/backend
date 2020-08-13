package com.codegym.dao.repository;

import java.util.List;

import com.codegym.dao.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codegym.dao.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDeleteFlagIsFalse();

    List<Employee> findAllByDeleteFlagIsTrue();

    Employee findByDeleteFlagIsFalseAndId(Integer id);

    Employee findByAccount_AccountIdAndDeleteFlagIsFalse(int accountId);

    Employee findByAccount_AccountName(String accountName);

    Page<Employee> findAllByNameContainingOrPhoneNumberContainingOrEmailContainingOrPosition_NameOrDepartment_NameAndDeleteFlagIsFalse(String key1, String key2, String key3, String key4, String key5, Pageable pageable);

}
