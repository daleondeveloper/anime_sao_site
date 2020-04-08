package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.dao.DBFileRepository;
import ua.daleondeveloper.sao_site.domain.Files.File;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.exception.FileNotFoundException;
import ua.daleondeveloper.sao_site.exception.FileStorageException;
import ua.daleondeveloper.sao_site.exception.NoAccess;

import java.io.IOException;
import java.util.Optional;

@Service
public class DBFileStorageService {

    @Autowired
    DBFileRepository dbFileRepository;

    public File storeFile (MultipartFile file){
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            //Check if the files name contains invalid characters
            if(fileName.contains("src/test")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }

    }

    public File getFile (Long fileId, Optional<User> user){
        File file = dbFileRepository.findById(fileId).
                orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
        if(user.isPresent() && file.getAccess() != null) {
            for (UserRole role : user.get().getRoles()) {
                if (role.getName().equals(file.getAccess().toString())) {
                    return file;
                }
            }
        }
        if(file.getAccess() == RoleEnum.GUEST || file.getAccess() == null){
            return file;
        }
        throw new NoAccess("No access to file");
    }
}
