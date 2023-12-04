package com.m2olie.documentService.controller;

import com.m2olie.documentService.model.Document;
import com.m2olie.documentService.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    public DocumentController() {
    }

    @GetMapping
    public ResponseEntity<List<Document>> getDocumentList() {
        return new ResponseEntity<>(documentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        return documentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Document> addDocument(@RequestBody Document requestDocument) {
        if (requestDocument.getDocumentID() == null) {
            Document savedDocument = documentService.saveOrUpdate(requestDocument);
            return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document requestDocument) {
        return documentService.findById(id)
                .map(document -> {
                    requestDocument.setDocumentID(id);
                    Document updatedDocument = documentService.saveOrUpdate(requestDocument);
                    return new ResponseEntity<>(updatedDocument, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeDocument(@PathVariable Long id) {
        documentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
