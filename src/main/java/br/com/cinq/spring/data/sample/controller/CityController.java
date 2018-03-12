package br.com.cinq.spring.data.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinq.spring.data.sample.endpoint.Path;
import br.com.cinq.spring.data.sample.exceptions.KeywordNotFoundException;
import br.com.cinq.spring.data.sample.messages.Messages;
import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.service.CityService;

@RestController
@RequestMapping(path = Path.urls.CITY)
public class CityController {
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private CityService cityService;
	
	/**
	 * Method returns the list of cities to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<City>> listALL() {
		
		List<City> cities = cityService.findCitiesList();
		
		if(cities.isEmpty()){
			
			return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
		
	}

	/**
	 * Method returns the list of cities to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<City>> listCitiesByCountry(@RequestParam("country") String country) {
		
		List<City> cities = cityService.findCityByCountryNameThroughSomeChars(country);
		
		if(cities.isEmpty()){
			
			return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
		
	}
	
	/**
	 * Method returns the city object by its id parameter
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{cityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> getCityById(@PathVariable Integer cityId) {

		City cities = cityService.findCityById(cityId);
		
		if (cities != null) {
		
			return new ResponseEntity<City>(cities, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(cityId, Messages.MESSAGE_SEARCH_FAIL);
			
		}
	}
	
	/**
	 * Method saves an city object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<City> saveCity(@RequestBody City city) {
		
		cityService.saveCityInfo(city);
		
		return new ResponseEntity<City>(city, HttpStatus.CREATED);
		
	}
	
	/**
	 * Method updates an city object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{cityId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<City> updateCityInfo(@PathVariable Integer cityId, @RequestBody City city) {

		City cityUpdated = cityService.updateCityInformation(cityId, city);

		if (cityUpdated != null) {
			
			return new ResponseEntity<City>(cityUpdated, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(cityId, Messages.MESSAGE_UPDATE_FAIL);
			
		}
	}
	
	/**
	 * Method deletes an city object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{cityId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer cityId) {

		try {
			
			cityService.removeCityInformation(cityId);
			
		} catch (Exception e) {
			throw new KeywordNotFoundException(cityId, Messages.MESSAGE_DELETE_FAIL);
		}
	}

}
