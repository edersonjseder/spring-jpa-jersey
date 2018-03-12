package br.com.cinq.spring.data.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.repository.CountryRepository;

/**
 * Country service class used to get data from controller and do some
 * business logic if needed, and passes it to the database layer
 * 
 * @author ederson
 *
 */
@Service
public class CountryService {
	
    /** The CountryService logger */
    private static final Logger LOG = LoggerFactory.getLogger(CountryService.class);
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private CountryRepository countryRepository;

    /**
     * Retrieves a country list for the requested client.
     * 
     * @return a Country list for the requested client or null/empty if none is found.
     */
	public List<Country> findCountriesList(){
		
		List<Country> countries = null; 
				
		try {
			
			countries = countryRepository.findAll();
			
		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}
		
		return countries;
	}
	
    /**
     * Retrieves a country for the given id.
     * 
     * @param countryId The id to look for the country object
     * @return a Country given the id passed or null if none is found.
     */
	public Country findCountryById(Integer countryId) {
		
		Country countryLoaded = null;
		
		try {

			countryLoaded = countryRepository.findById(countryId);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return countryLoaded;
	}

    /**
     * Retrieves a country for the given name.
     * 
     * @param countryName The name to look for the country object
     * @return a Country given the name passed or null if none is found.
     */
	public Country findCountryByName(String countryName) {
		
		Country countryLoaded = null;
		
		try {

			countryLoaded = countryRepository.findByName(countryName);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return countryLoaded;
	}

    /**
     * Retrieves a list of countries like the given name.
     * 
     * @param countryLikeName The name to look for the list country object
     * @return a list of Country objects for the given like name passed or null if none is found.
     */
	public List<Country> findCountryLikeName(String countryLikeName) {
		
		List<Country> countryLoaded = null;
		
		try {

			countryLoaded = countryRepository.findLikeName(countryLikeName);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return countryLoaded;
	}

	/**
     * Creates a new country for the client requested.
     *
     * @param country The Country object containing the data.
     * @return a new country object for the requested client.
     */
	public Country saveCountryInfo(Country country) {
		
		Country countrySaved = countryRepository.save(country);
		
		return countrySaved;
	}
	
    /**
     * Updates a country for the given id.
     * 
     * @param countryId The id to look for the country object
     * @param country The Country object
     * @return a updated country given the id passed or null if none is found.
     */
	public Country updateCountryInformation(Integer countryId, Country country) {

		Country countryUpdated = null;
		
		try {

			countryUpdated = countryRepository.findById(countryId);

			if (countryUpdated != null) {
				
				countryUpdated.setName(country.getName());
				
				countryRepository.save(countryUpdated);
				
			}

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}
		
		return countryUpdated;
			
	}
	
    /**
     * Removes a country for the given id.
     * 
     * @param countryId The id to look for the country object
     */
	public void removeCountryInformation(Integer countryId) throws Exception{

		countryRepository.delete(countryId);
		
	}

}
