package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.warehouseapp.entity.Attachment;
import uz.pdp.warehouseapp.entity.AttachmentContent;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.AttachmentContentRepository;
import uz.pdp.warehouseapp.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class AttachmentController {
    public static final String uploadDirectory = "upload";
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    //    db un
    @PostMapping("/upload")
    public ApiResponse saveToDb(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            Attachment attachment = new Attachment();
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());

            Attachment save = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(save);
            attachmentContent.setContent(file.getBytes());

            attachmentContentRepository.save(attachmentContent);
            return new ApiResponse("Saved !", true, attachment);
//            byte[] bytes = file.getBytes();
//            String name = file.getName();
//            String contentType = file.getContentType();
//            String originalFilename = file.getOriginalFilename();
        }
        return new ApiResponse("Error upload file!", false);
    }

    @GetMapping("/download/{id}")
    public void getFromDb(@PathVariable UUID id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            AttachmentContent attachmentContent = optionalAttachmentContent.get();
            if (optionalAttachmentContent.isPresent()) {

                response.setContentType(attachment.getContentType());
                response.setHeader("Content-Disposition", attachment.getName() + "/:" + attachment.getSize());
                FileCopyUtils.copy(attachmentContent.getContent(), response.getOutputStream());
            }
        }
    }


}
