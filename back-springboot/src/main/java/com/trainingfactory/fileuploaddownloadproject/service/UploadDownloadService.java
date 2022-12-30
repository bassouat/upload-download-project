package com.trainingfactory.fileuploaddownloadproject.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UploadDownloadService {

    private static final String path="C:/Users/hp/Desktop/files";

   public List<String> upLoadFile(MultipartFile file) throws Exception{

       /*save file on system*/
    if (!Objects.requireNonNull(file.getOriginalFilename()).isEmpty()){
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path,file.getOriginalFilename())));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
    }else{
        throw new Exception("Attention fichier vide");
    }

       File files = new File(path);
       String[] fileList = files.list();
       ArrayList<String> strings=null;
       if(!StringUtils.isEmpty(fileList)){
           strings = new ArrayList<>(Arrays.asList(fileList));
       }

       return strings;
    }

    public List<String> getListofFiles() {

        File files = new File(path);
        String[] fileList = files.list();
        ArrayList<String> strings=null;
        if (fileList != null){
             strings = new ArrayList<>(Arrays.asList(fileList));

        }

        return strings;

    }
}
