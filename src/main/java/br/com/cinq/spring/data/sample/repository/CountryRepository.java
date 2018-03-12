package br.com.cinq.spring.data.sample.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cinq.spring.data.sample.model.Country;

@Repository
public class CountryRepository {
	
	@Autowired
	private CountryRepositoryImpl repository;

	@PersistenceContext
	EntityManager em;
	
	public Country findByName(String name) {
		return repository.findByName(name);
	}
	
	public Country findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Country> findAll() {
		return repository.findAll();
	}

	public Country save(Country country) {
		return repository.save(country);
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	public long count() {
		return repository.count();
	}
	
	public List<Country> findLikeName(String name) {

		/**
		 * HQL query to reach the country information
		 */
	    String sql = "select co.id, co.name " + 
	    			 "from Country co " +
	    			 "where co.name like CONCAT('%',:name,'%')";
	    
	    // attributing the given parameter
	    Query query = em.createQuery(sql).setParameter("name", name);
	    
	    // Iterating through the object array results
	    Iterator<?> iterator = query.getResultList().iterator();
	    
	    // Obtaining the country list
		return getCountryList(iterator);
	}
	
	/**
	 * This method is to get the country information got from database, based on the query
	 *  information given to Hibernate it was returned an array of Objects containing and 
	 *  array of information objects with the needed data for country respective objects
	 * 
	 * @param iterator used to iterate through the object array
	 * @return The Country list with the query result
	 */
	private List<Country> getCountryList(Iterator<?> iterator) {

	    List<Country> countries = new ArrayList<Country>();
	    
	    while(iterator.hasNext()) {

	    	Country country = new Country();	// Country entity
	    	Object[] tuple = (Object[]) iterator.next(); // array of objects
	    	
	    	// iterate through the object array to get the needed information for Country and country
	    	for (int i = 0; i < tuple.length; i++) {
	    		// switch to fill the Country and country fields
				switch(i) {
					case 0:
						country.setId((int)tuple[i]); // Filling the Country id data
						break;
					case 1:
						country.setName((String)tuple[i]); // Filling the Country name data
						break;
				}
			}
	    	
	    	// adding Country entities to the list
	    	countries.add(country);
	    	
	    }
	 
	    return countries;
	    
	}
	
}
