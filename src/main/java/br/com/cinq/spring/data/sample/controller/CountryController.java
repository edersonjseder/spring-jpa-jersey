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
import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.service.CountryService;

@RequestMapping(value = Path.urls.COUNTRY)
@RestController
public class CountryController {
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private CountryService countryService;
	
	/**
	 * Method returns the list of countries to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> listALL() {
		
		List<Country> countries = countryService.findCountriesList();
		
		if(countries.isEmpty()){
			
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
		
	}

	/**
	 * Method returns the list of cities to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> listCountryByName(@RequestParam("name") String name) {
		
		List<Country> countries = countryService.findCountryLikeName(name);
		
		if(countries.isEmpty()){
			
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
		
	}
	
	/**
	 * Method returns the country object by its id parameter
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{countryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> getCountryById(@PathVariable Integer countryId) {

		Country country = countryService.findCountryById(countryId);
		
		if (country != null) {
		
			return new ResponseEntity<Country>(country, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(countryId, Messages.MESSAGE_SEARCH_FAIL);
			
		}
	}
	
	/**
	 * Method saves a country object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Country> saveCountry(@RequestBody Country country) {
		
		countryService.saveCountryInfo(country);
		
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
		
	}
	
	/**
	 * Method updates a country object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{countryId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Country> update(@PathVariable Integer countryId, @RequestBody Country country) {

		Country countryUpdated = countryService.updateCountryInformation(countryId, country);

		if (countryUpdated != null) {
						
			return new ResponseEntity<Country>(country, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(countryId, Messages.MESSAGE_UPDATE_FAIL);
			
		}
	}
	
	/**
	 * Method deletes an country object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{countryId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer countryId) {

		try {

			countryService.removeCountryInformation(countryId);

		} catch (Exception e) {
			
			throw new KeywordNotFoundException(countryId, Messages.MESSAGE_DELETE_FAIL);
			
		}
	}

}
