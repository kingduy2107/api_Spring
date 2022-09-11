package com.example.final_spring.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileSystemStorageServiceImp {
	
	public void init();

	// hàm savefile khi người dùng đẩy file lên dưới dạng multipartfile thì ta sẽ
	// hứng folder đó là lưu vào cái file mà ta đã tạo thông qua thằng init
	public boolean saveFile(MultipartFile file);

	public Resource loadFile(String fileName);
	
	
	
}
