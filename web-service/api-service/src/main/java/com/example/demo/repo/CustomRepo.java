package com.example.demo.repo;

import com.example.demo.entity.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepo extends JpaRepository<Custom, Integer> {

    @Procedure(procedureName = "sp_test")
    String callProcedure();

}

