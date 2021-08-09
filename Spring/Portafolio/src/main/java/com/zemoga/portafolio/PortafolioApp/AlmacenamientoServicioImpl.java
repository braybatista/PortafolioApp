package com.zemoga.portafolio.PortafolioApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AlmacenamientoServicioImpl implements AlmacenamientoServicio {

	@Override
	public Resource load(String id) {
		try {
			Path file = Paths.get("resources").resolve(id+"\\image.jpg");
			Resource resource = new UrlResource(file.toUri());
			
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				System.out.println();
				return new UrlResource(Paths.get("resources\\image.png").toUri());
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public void save(MultipartFile file, String id) {
		Path root = Paths.get("resources" + "\\" + id + "\\");
		try {

			if (!Files.isDirectory(root)) {
				Files.createDirectory(root);
			}

			Files.deleteIfExists(root.resolve("image.jpg"));
			Files.copy(file.getInputStream(), root.resolve("image.jpg"));

		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}
}