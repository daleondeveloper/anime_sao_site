package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.dao.ImageRepository;
import ua.daleondeveloper.sao_site.domain.Files.Image;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.exception.FileStorageException;
import ua.daleondeveloper.sao_site.exception.FileNotFoundException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image storeImage (MultipartFile file){
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            //Check if the files name contains invalid characters
            if(fileName.contains("src/test")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Image dbFile = new Image(LocalDate.now(), LocalTime.now(),fileName, file.getContentType(), file.getBytes());
            dbFile.setCreateDate(LocalDate.now());
            dbFile.setCreateTime(LocalTime.now());
            return imageRepository.save(dbFile);
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }

    }
    public Page<Image> getAnimeByNumber(int start, int end){
        return imageRepository.findAll(PageRequest.of(1,3, Sort.by("data")));
    }
    public Image getImage (Long fileId){
        return imageRepository.findById(fileId).
                orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}
