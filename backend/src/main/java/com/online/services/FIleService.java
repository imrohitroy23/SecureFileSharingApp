package com.online.services;
import java.util.stream.Stream;
import java.io.IOException;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.online.Repository.FileRepo;
import com.online.model.File;

@Service
public class FIleService {
    @Autowired
    private FileRepo fileRepo;

    public File store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File FileDB = new File(fileName,file.getContentType(),file.getBytes());
    
        return fileRepo.save(FileDB);
      }
    
      public File getFile(String id) {
        return fileRepo.findById(id).get();
      }
      
      public Stream<File> getAllFiles() {
        return fileRepo.findAll().stream();
      }
}
