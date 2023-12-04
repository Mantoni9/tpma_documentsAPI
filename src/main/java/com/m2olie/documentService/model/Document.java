package com.m2olie.documentService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long documentID;
    private String title;
    private Date dateUploaded;

    private String fileName;
    // Later change to real file
    private long fileID;

    @Enumerated(value = EnumType.ORDINAL)
    private FileType fileType;

/*    public Document() {
    }

    public Document(String title, long fileID, Date dateUploaded, String fileName, FileType fileType) {
        this.title = title;
        this.fileID = fileID;
        this.dateUploaded = dateUploaded;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((documentID == null) ? 0 : documentID.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((dateUploaded == null) ? 0 : dateUploaded.hashCode());
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + (int) (fileID ^ (fileID >>> 32));
        result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Document other = (Document) obj;
        if (documentID == null) {
            if (other.documentID != null)
                return false;
        } else if (!documentID.equals(other.documentID))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (dateUploaded == null) {
            if (other.dateUploaded != null)
                return false;
        } else if (!dateUploaded.equals(other.dateUploaded))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (fileID != other.fileID)
            return false;
        if (fileType != other.fileType)
            return false;
        return true;
    }*/
}
