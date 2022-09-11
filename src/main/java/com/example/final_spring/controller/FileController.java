package com.example.final_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_spring.service.FileSystemStorageServiceImp;

@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	FileSystemStorageServiceImp fileSystemStorageServiceImp;
	
	
	
	@GetMapping("/{filename}")
	public ResponseEntity<Resource> getFile(@PathVariable("filename") String filename) { 
		Resource file = fileSystemStorageServiceImp.loadFile(filename);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
