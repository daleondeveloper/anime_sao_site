package ua.daleondeveloper.sao_site.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.daleondeveloper.sao_site.domain.Files.File;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.dto.UploadFileResponse;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/file/")
public class FileRestController {

    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        File dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(String.valueOf(dbFile.getId()))
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity downloadFile(@PathVariable Long fileId, HttpServletRequest request) {
        //Get User by token
        Optional<User> tokenUser = userService.findByToken(request);
        // Load file from database
        File file = dbFileStorageService.getFile(fileId, tokenUser);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(file.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                    .body(Base64.getEncoder().encodeToString(file.getData()));

    }
}