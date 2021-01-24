package com.jumia.task.repository;

import com.jumia.task.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Query( nativeQuery = true, value = "SELECT load_extension('/usr/lib/sqlite3/pcre')")
    void init();

    @Query( nativeQuery = true, value = "SELECT * FROM customer WHERE :regex regexp phone")
    Page<Customer> findByPhoneRegex(String regex, Pageable pageable);
}
