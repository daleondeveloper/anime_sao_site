package ua.daleondeveloper.sao_site.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Image create date
    private LocalDate createDate;
    private LocalTime createTime;

    private String fileName;
    //Image type(jpg, png ...)
    private String contentType;

    @Lob
    private byte[] data;

    public Image(LocalDate createDate, LocalTime createTime, String fileName, String contentType, byte[] data) {
        this.createDate = createDate;
        this.createTime = createTime;
        this.fileName = fileName;
        this.contentType = contentType;
        this.data = data;
    }
}
