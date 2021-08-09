package com.zemoga.portafolio.PortafolioApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PortafolioRepositorio")
public interface PortafolioRepositorio extends CrudRepository<Portafolio, Integer>{
	
}
