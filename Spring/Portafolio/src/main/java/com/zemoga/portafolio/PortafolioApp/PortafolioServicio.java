package com.zemoga.portafolio.PortafolioApp;

import java.util.List;

public interface PortafolioServicio {
	
	public abstract List<Portafolio> listarPortafolio();
	
	public abstract Portafolio guardarPortafolio(Portafolio p);
}
