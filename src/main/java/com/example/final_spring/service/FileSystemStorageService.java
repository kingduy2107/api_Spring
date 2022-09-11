package com.example.final_spring.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileSystemStorageService implements FileSystemStorageServiceImp {

	private final Path root = Paths.get("uploads");
	
	@Override
	public void init() {
	
		try {
			if (!Files.exists(root)) {
				Files.createDirectories(root);
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't create folder uploads");
		}

	}

	
	@Override
	public boolean saveFile(MultipartFile file) {
		
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Can't copy file to folder uploads");
		}

	}
	

	@Override
	public Resource loadFile(String fileName) {
		// TODO Auto-generated method stub

		try {
			Path path = this.root.resolve(fileName); // uploads/abc.jpg
			Resource resource = new UrlResource(path.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Can't found file");
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Can't found file");
		}
	}


}
