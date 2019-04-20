package com.example.demo;

import com.example.demo.repo.CustomRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private CustomRepo customRepo;
	@Test
	public void contextLoads() {
        StoredProcedureQuery sp_test = entityManager.createStoredProcedureQuery("sp_test");
        sp_test.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
        Object str = sp_test.getOutputParameterValue(1);
        System.out.println(str);
    }

}
