package br.com.cinq.spring.data.repository.test;
//
//import com.devopsbuddy.DevopsbuddyApplication;
//import com.devopsbuddy.backend.persistence.domain.backend.Plan;
//import com.devopsbuddy.backend.persistence.domain.backend.Role;
//import com.devopsbuddy.backend.persistence.domain.backend.User;
//import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
//import com.devopsbuddy.enums.PlansEnum;
//import com.devopsbuddy.enums.RolesEnum;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TestName;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Set;
//import java.util.UUID;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.repository.CountryRepository;

/**
 * Created by root on 09/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CountryRepositoryTest {
	
	 @Autowired
	 private CountryRepository dao;

	@Test
	public void testGelAllCountries() {

		 Assert.assertNotNull(dao);

		 long count = dao.count();

		 Assert.assertTrue(count > 0);

		 List<Country> countries = dao.findAll();

		 Assert.assertEquals((int) count, countries.size());
	}

	@Test
	public void testFindOneCountry() {

		 Assert.assertNotNull(dao);

		 List<Country> countries = dao.findLikeName("Fra");

		 Assert.assertEquals(1, countries.size());

	}
}
