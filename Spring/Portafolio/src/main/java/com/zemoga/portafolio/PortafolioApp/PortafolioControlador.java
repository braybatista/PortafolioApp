package com.zemoga.portafolio.PortafolioApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/portafolio")
@CrossOrigin(origins = "*")
public class PortafolioControlador {

	@Autowired
	@Qualifier("PortafolioServicioImpl")
	private PortafolioServicioImpl servicio;

	@Autowired
	@Qualifier("twitter4J")
	private Twitter4J getTwitterinstance;

	@Autowired
	AlmacenamientoServicioImpl storageService;

	@GetMapping
	public List<Portafolio> listarPersonas() {
		return servicio.listarPortafolio();
	}

	@PostMapping
	public Portafolio agregarPersona(@RequestBody Portafolio p) {
		return servicio.guardarPortafolio(p);
	}

	@GetMapping("/tweets")
	public List<String> getTweets() {
		return getTwitterinstance.searchtweets();
	}

	@RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
		try {
			storageService.save(file, id);
			return ResponseEntity.status(HttpStatus.OK).body("Archivo creado correctamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error: Al crear el archivo.");
		}
	}

	@RequestMapping(value= "/get/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String id) {
		Resource file = storageService.load(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"images.jpg\"")
				.body(file);
	}
	
	@RequestMapping(value= "/get2/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<String>> getFile2(@PathVariable String id) {
		Resource file = storageService.load(id);
		List<String> image = new ArrayList<String>();
		String encodeBase64 = "";
		try {
			
			File fileOut = file.getFile();
			String extension = file.getFilename().split("\\.")[1];
			FileInputStream fileInS = new FileInputStream(fileOut);
			byte[] bytes = new byte[(int) fileOut.length()];
			fileInS.read(bytes);
			encodeBase64 = java.util.Base64.getEncoder().encodeToString(bytes);
			image.add("data:image/"+extension+";base64,"+encodeBase64);
			fileInS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(image);
	}

}
