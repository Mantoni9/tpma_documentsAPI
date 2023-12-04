package com.m2olie.documentService.controller;

import com.m2olie.documentService.model.File;
import com.m2olie.documentService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/files") // Basispfad geändert
@CrossOrigin(maxAge = 3600)
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Long> upload(@RequestParam("file") MultipartFile file) {
        try {
            File fileEntity = new File();
            fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
            fileEntity.setContentType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setSize(file.getSize());

            File savedFile = fileService.saveOrUpdate(fileEntity);

            return new ResponseEntity<>(savedFile.getFileID(), HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<File> fileEntityOptional = fileService.findById(id);

        if (!fileEntityOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        File fileEntity = fileEntityOptional.get();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }

}
