package ua.daleondeveloper.sao_site.domain.Files;


import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String fileName;

    private String fileType;

    protected String contentType;

    @Lob
    private byte[] data;

    @Column(name = "access")
    @Enumerated(EnumType.STRING)
    private RoleEnum access;

    public File(){

    }

    public File(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public File(String fileName, String fileType, byte[] data, RoleEnum access) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.access = access;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public RoleEnum getAccess() {
        return access;
    }

    public void setAccess(RoleEnum access) {
        this.access = access;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
