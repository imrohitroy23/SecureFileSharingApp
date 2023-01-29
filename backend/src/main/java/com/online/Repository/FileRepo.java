package com.online.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.File;

public interface FileRepo extends JpaRepository<File,String>{
    
}