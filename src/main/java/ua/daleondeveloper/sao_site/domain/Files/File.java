package ua.daleondeveloper.sao_site.domain.Files;


import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "files")
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    protected String fileName;

    protected String contentType;

    //Image create date
    protected LocalDate createDate;
    protected LocalTime createTime;

    @Lob
    protected byte[] data;

    @Column(name = "access")
    @Enumerated(EnumType.STRING)
    protected RoleEnum access;

    public File(){

    }

    public File(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.contentType = fileType;
        this.data = data;
    }

    public File(String fileName, String fileType, byte[] data, RoleEnum access) {
        this.fileName = fileName;
        this.contentType = fileType;
        this.data = data;
        this.access = access;
    }

}
