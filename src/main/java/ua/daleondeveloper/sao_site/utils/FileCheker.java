package ua.daleondeveloper.sao_site.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.exception.BadFileTypeException;
import ua.daleondeveloper.sao_site.exception.FileToBigException;
import ua.daleondeveloper.sao_site.utils.constants.FileConstants;

public class FileCheker {

    public static boolean chekImageFile(MultipartFile file) throws BadFileTypeException,FileToBigException{
//Check if file has image type
        if (!file.getContentType().split("/")[0].equals("image")) {
            throw new BadFileTypeException("File type must be image");
        }

        if (file.getSize() > FileConstants.MAX_IMAGE_SIZE) {
            throw new FileToBigException("File size is to big");
        }
        return true;
    }
}
