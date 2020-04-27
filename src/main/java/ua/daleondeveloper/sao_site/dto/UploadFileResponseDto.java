package ua.daleondeveloper.sao_site.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UploadFileResponseDto {

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponseDto(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

}
