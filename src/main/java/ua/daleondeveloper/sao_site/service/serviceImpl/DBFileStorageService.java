package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.dao.DBFileRepository;
import ua.daleondeveloper.sao_site.domain.DBFile;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.exception.FileStorageException;
import ua.daleondeveloper.sao_site.exception.MyFileNotFoundException;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    DBFileRepository dbFileRepository;

    public DBFile storeFile (MultipartFile file){
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            //Check if the files name contains invalid characters
            if(fileName.contains("src/test")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }

    }

    public DBFile getFile (Long fileId, ){
        return dbFileRepository.findById(fileId).
                orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
