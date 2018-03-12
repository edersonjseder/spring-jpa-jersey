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
import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;

/**
 * Created by root on 09/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CityRepositoryTest {
	
	 @Autowired
	 private CityRepository dao;

	@Test
	public void testQueryPerson() {
		 Assert.assertNotNull(dao);

		 Assert.assertTrue(dao.count()>0);

		 Country country = new Country();
		 country.setId(3); // Should be France

		 List<City> list = dao.findByCountry(country);

		 Assert.assertEquals(2, list.size());
	}
}
