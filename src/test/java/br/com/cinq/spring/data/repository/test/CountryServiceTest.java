package br.com.cinq.spring.data.repository.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.service.CountryService;
import br.com.cinq.spring.data.sample.util.Utils;

/**
 * Created by root on 10/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CountryServiceTest {

	@Autowired
	private CountryService countryService;
	
	private String countryName = "Chile";
	
    @Test
    public void testCreateNewCountry() throws Exception {

        Country country = Utils.createCountry(countryName);
        
        country = countryService.saveCountryInfo(country);

        Assert.assertNotNull(country);
        Assert.assertNotNull(country.getId());
        
    }

    @Test
    public void testUpdateCountry() throws Exception {

        Country country = countryService.findCountryByName(countryName);
        

        if (country != null) {

        	Assert.assertNotNull(country);
        	Assert.assertNotNull(country.getId());
        	
        	Assert.assertEquals(country.getName(), countryName);
        	
        	country.setName("Spain");
        	
        	country = countryService.updateCountryInformation(country.getId(), country);

        }

    }

    @Test
    public void testRemoveCountry() throws Exception {

        Country country = countryService.findCountryByName(countryName);
        
        if (country != null) {
        	Assert.assertNotNull(country);
        	Assert.assertNotNull(country.getId());

        	countryService.removeCountryInformation(country.getId());
        	
        } 

    }
    
}
