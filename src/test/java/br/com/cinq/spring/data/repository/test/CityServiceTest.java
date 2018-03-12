package br.com.cinq.spring.data.repository.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.service.CityService;
import br.com.cinq.spring.data.sample.util.Utils;

/**
 * Created by root on 10/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CityServiceTest {

	@Autowired
	private CityService cityService;
	
	private String cityName = "Aconcagua";
	
    @Test
    public void testCreateNewCity() throws Exception {

        City city = Utils.createCity(cityName);
        
        city = cityService.saveCityInfo(city);

        Assert.assertNotNull(city);
        Assert.assertNotNull(city.getId());
        
    }

    @Test
    public void testUpdateCity() throws Exception {

        City city = cityService.findCityByName(cityName);
        
        if(city != null) {
        	
        	Assert.assertNotNull(city);
        	Assert.assertNotNull(city.getId());

        	Assert.assertEquals(city.getName(), cityName);
        	
        	city.setName("Cordoba");
        	
        	city = cityService.updateCityInformation(city.getId(), city);

        }

    }

    @Test
    public void testRemoveCity() throws Exception {

        City city = cityService.findCityByName(cityName);

        if(city != null) {
        	
        	Assert.assertNotNull(city);
        	Assert.assertNotNull(city.getId());

        	cityService.removeCityInformation(city.getId());
        	
        }

    }
    
}
