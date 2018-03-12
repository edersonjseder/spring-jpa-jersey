package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cinq.spring.data.sample.model.Country;


@Repository
@Transactional
public interface CountryRepositoryImpl extends CrudRepository<Country, Integer> {
	
	public Country findByName(String name);
	public Country findById(Integer id);
	public List<Country> findAll();

	@Query("select co from Country co where co.name like :name")
	public List<Country> findLikeName(String name);

}
