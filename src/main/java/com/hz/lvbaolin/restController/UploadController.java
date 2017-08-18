package com.hz.lvbaolin.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by master-lv on 2017/7/27.
 */
@RestController
public class UploadController {

    protected static Logger logger = LoggerFactory.getLogger(UploadController.class);

    private String outputFolder = "/upload";

    /**
     * Upload single file and save to src/main/resources/output-folders
     * @param uploadedFile
     * @param redirectAttributes
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/singleFileUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String singleFileUpload(@RequestParam("file") MultipartFile uploadedFile,
                                   RedirectAttributes redirectAttributes) throws IOException {
        String uploadStatus = "Please select the file to upload";
        if (null != uploadedFile && !uploadedFile.isEmpty()) {
            uploadStatus = uploadedFile.getOriginalFilename() + " file upload success";
            File destination = new File(outputFolder + uploadedFile.getOriginalFilename());
            logger.info(destination.getPath());
            uploadedFile.transferTo(destination);
        }
        return uploadStatus;
    }

    /**
     * upload multiple files and save to src/main/resource/output-files
     * @param uploadedFiles
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/multiFileUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> multiFileUpload(@RequestParam("files") MultipartFile[] uploadedFiles,
                                               RedirectAttributes redirectAttributes) throws IOException {
        Map<String, Object> uploadStatusMap = new LinkedHashMap<>();
        List<String> fileUploadStatus = new ArrayList<>();
        if (null != uploadedFiles && uploadedFiles.length > 0) {
            for (MultipartFile file : uploadedFiles) {
                fileUploadStatus.add(file.getOriginalFilename() + " file upload success.");
                File destination = new File(outputFolder + file.getOriginalFilename());
                file.transferTo(destination);
            }
            uploadStatusMap.put("noOfFiles", uploadedFiles.length);
        } else {
            fileUploadStatus.add("Please select the file to upload");
        }
        uploadStatusMap.put("uploadStatus", fileUploadStatus);
        return uploadStatusMap;
    }

}



