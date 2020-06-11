package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.dao.DBFileRepository;
import ua.daleondeveloper.sao_site.domain.Files.File;
import ua.daleondeveloper.sao_site.domain.Files.Image;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.exception.FileNotFoundException;
import ua.daleondeveloper.sao_site.exception.FileStorageException;
import ua.daleondeveloper.sao_site.exception.NoAccess;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Service
public class DBFileStorageService {

    @Autowired
    DBFileRepository dbFileRepository;

    public File storeFile (File file){

            return dbFileRepository.save(file);
    }

    public File getFile (Long fileId, User user){
        if(fileId == null){
return null;
        }
        File file = dbFileRepository.findById(fileId).
                orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
        if(file.getAccess() != null && user != null) {
            for (UserRole role : user.getRoles()) {
                if (role.getName().equals(file.getAccess().toString())) {
                    return file;
                }
            }
        }
        if(file.getAccess() == RoleEnum.ROLE_GUEST || file.getAccess() == null){
            return file;
        }
        throw new NoAccess("No access to file");
    }
}
