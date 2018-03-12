package br.com.cinq.spring.data.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.model.Country;
import br.com.cinq.spring.data.sample.repository.CityHqlSearchRepositoryImpl;
import br.com.cinq.spring.data.sample.repository.CityRepository;

/**
 * City service class used to get data from controller and do some
 * business logic if needed, and passes it to the database layer
 * 
 * @author ederson
 *
 */
@Service
public class CityService {
	
    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(CityService.class);
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * Dependency Injection of Spring Framework
	 * The inner join HQL query for reaching cities based 
	 * on the given name passed in the URL
	 */
	@Autowired
	private CityHqlSearchRepositoryImpl searchImpl;
	
    /**
     * Retrieves a city list for the requested client.
     * 
     * @return a City list for the requested client or null/empty if none is found.
     */
	public List<City> findCitiesList(){
		
		List<City> cities = null; 
				
		try {
			
			cities = cityRepository.findAll();
			
		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}
		
		return cities;
	}
	
	/**
	 * Finds a city by country name param or characters containing on the given country name
	 * 
	 * @param country The country param info given by the client
	 * @return The list of Cities bases on the param values
	 */
	public List<City> findCityByCountryNameThroughSomeChars(String country) {

		List<City> cities = null;

		try {
			
			cities = searchImpl.listCityByGivenCountryName(country);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return cities;
	}

    /**
     * Retrieves a city for the given id.
     * 
     * @param cityId The id to look for the city object
     * @return a City given the id passed or null if none is found.
     */
	public City findCityById(Integer cityId) {
		
		City cityLoaded = null;
		
		try {

			cityLoaded = cityRepository.findOne(cityId);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return cityLoaded;
	}

    /**
     * Retrieves a city for the given name.
     * 
     * @param cityName The name to look for the city object
     * @return a City given the name passed or null if none is found.
     */
	public City findCityByName(String cityName) {
		
		City cityLoaded = null;
		
		try {

			cityLoaded = cityRepository.findByName(cityName);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return cityLoaded;
	}

    /**
     * Retrieves a city for the given name.
     * 
     * @param cityName The name to look for the city object
     * @return a City given the name passed or null if none is found.
     */
	public List<City> findCityByCountry(Country country) {
		
		List<City> citiesLoaded = null;
		
		try {

			citiesLoaded = cityRepository.findByCountry(country);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}

		return citiesLoaded;
	}
	
    /**
     * Creates a new city for the client requested.
     *
     * @param city The City object containing the data.
     * @return a new city object for the requested client.
     */
	public City saveCityInfo(City city) {
		
		City citySaved = cityRepository.save(city);
		
		return citySaved;
	}

    /**
     * Updates a city for the given id.
     * 
     * @param cityId The id to look for the city object
     * @param city The City object
     * @return a updated city given the id passed or null if none is found.
     */
	public City updateCityInformation(Integer cityId, City city) {

		City cityUpdated = null;
		
		try {

			cityUpdated = cityRepository.findOne(cityId);

			if (cityUpdated != null) {
				
				cityUpdated.setName(city.getName());
				
			}
			
			cityRepository.save(cityUpdated);

		} catch (Exception e) {
			LOG.error("Problem with loading data {} ", e.getMessage());
		}
		
		return cityUpdated;
			
	}

    /**
     * Removes a city for the given id.
     * 
     * @param cityId The id to look for the city object
     */
	public void removeCityInformation(Integer cityId) throws Exception{

		cityRepository.delete(cityId);

	}

}
