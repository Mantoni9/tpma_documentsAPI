package com.m2olie.documentService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long FileID;
    private String name;
    private String contentType;
    private Long size;
    @Lob
    private byte[] data;

}
