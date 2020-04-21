package ua.daleondeveloper.sao_site.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.Files.Image;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class ImageResponse {

    private Long id;
    private LocalDate createDate;
    private LocalTime createTime;
    private String fileName;
    private String contentType;

    public Image toImage(){
        Image image = new Image();
        if(id != null) {
            image.setId(id);
        }else{
            image.setId(0);
        }
        image.setCreateDate(createDate);
        image.setCreateTime(createTime);
        image.setFileName(fileName);
        image.setContentType(contentType);

        return image;
    }
    public static ImageResponse fromImage(Image image){
        ImageResponse imageDto = new ImageResponse();
        imageDto.setId(image.getId());
        imageDto.setCreateDate(image.getCreateDate());
        imageDto.setCreateTime(image.getCreateTime());
        imageDto.setFileName(image.getFileName());
        imageDto.setContentType(image.getContentType());
        return imageDto;
    }
}
