package com.m2olie.documentService.service;

import com.m2olie.documentService.model.File;
import com.m2olie.documentService.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveOrUpdate(File file) {
        return fileRepository.save(file);
    }

    public List<File> findAll() {
        return fileRepository.findAll();
    }

    public Optional<File> findById(Long id) {
        return fileRepository.findById(id);
    }

    public void delete(Long id) {
        fileRepository.deleteById(id);
    }
}
