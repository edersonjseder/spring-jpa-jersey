package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import br.com.cinq.spring.data.sample.model.City;

public interface CityHqlSearchRepository {

	// Lists the city entity by given country name information parameter
	public List<City> listCityByGivenCountryName(String country);
	
}
