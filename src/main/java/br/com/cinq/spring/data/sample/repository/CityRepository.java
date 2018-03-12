package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cinq.spring.data.sample.model.City;
import br.com.cinq.spring.data.sample.model.Country;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Integer> {

	public City findByName(String name);
	public City findById(Integer id);
	public List<City> findByCountry(Country country);
	
	public List<City> findAll();
	
}