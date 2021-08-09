package com.zemoga.portafolio.PortafolioApp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PortafolioServicioImpl")
@Transactional
public class PortafolioServicioImpl implements PortafolioServicio {
	
	@Autowired
	@Qualifier("PortafolioRepositorio")
	private PortafolioRepositorio repositorio;

	@Override
	public List<Portafolio> listarPortafolio() {
		return (List<Portafolio>) repositorio.findAll();
	}

	@Override
	public Portafolio guardarPortafolio(Portafolio p) {
		return repositorio.save(p);
	}

}
