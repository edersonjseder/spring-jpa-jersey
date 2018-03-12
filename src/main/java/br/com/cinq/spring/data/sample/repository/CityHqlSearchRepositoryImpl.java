package br.com.cinq.spring.data.sample.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.model.Country;

/**
 * City Repository to get city information with HQL
 * 
 * @author ederson
 *
 */
@Repository
public class CityHqlSearchRepositoryImpl implements CityHqlSearchRepository {
	
	@PersistenceContext
	EntityManager em;

	/**
	 * Method to list cities by given country name
	 */
	@Override
	public List<City> listCityByGivenCountryName(String name) {

		/**
		 * HQL query to reach the country and city information
		 */
	    String sql = "select c.id, c.name, co.id, co.name " + 
	    			 "from City c, Country co " +
	    			 "where c.country.id = co.id and co.name like CONCAT('%',:name,'%')";
	    
	    // attributing the given parameter
	    Query query = em.createQuery(sql).setParameter("name", name);
	    
	    // Iterating through the object array results
	    Iterator<?> iterator = query.getResultList().iterator();
	    
	    // Obtaining the city list
		return getCityList(iterator);
	}
	
	/**
	 * This method is to get the city information got from database, based on the query information given to Hibernate
	 * it was returned an array of Objects containing and array of information objects with the needed data for city and
	 * country respective objects
	 * 
	 * @param iterator used to iterate through the object array
	 * @return The city list with the query result
	 */
	private List<City> getCityList(Iterator<?> iterator) {

	    List<City> cities = new ArrayList<City>();
	    
	    while(iterator.hasNext()) {

	    	City city = new City();	// City entity
	    	city.setCountry(new Country()); // Country entity
	    	Object[] tuple = (Object[]) iterator.next(); // array of objects
	    	
	    	// iterate through the object array to get the needed information for city and country
	    	for (int i = 0; i < tuple.length; i++) {
	    		// switch to fill the city and country fields
				switch(i) {
					case 0:
						city.setId((int)tuple[i]); // Filling the city id data
						break;
					case 1:
						city.setName((String)tuple[i]); // Filling the city name data
						break;
					case 2:
						city.getCountry().setId((int)tuple[i]); // Filling the country id data
						break;
					case 3:
						city.getCountry().setName((String)tuple[i]); // Filling the country name data
						break;
				}
			}
	    	
	    	// adding city entities to the list
	    	cities.add(city);
	    	
	    }
	 
	    return cities;
	    
	}

}
