package ua.daleondeveloper.sao_site.domain;


import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "files")
public class DBFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    @Column(name = "access")
    @Enumerated(EnumType.STRING)
    private RoleEnum access;

    public DBFile(){

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public DBFile(String fileName, String fileType, byte[] data, RoleEnum access) {
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
}
