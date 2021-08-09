package com.zemoga.portafolio.PortafolioApp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface AlmacenamientoServicio {
	
  public void save(MultipartFile file, String id);
  
  public Resource load(String filename);

}