package com.example.printit.firebase.ws;


import com.example.printit.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FirebaseRest {

    @Autowired
    private FirebaseService firebaseService;

    /**
     * this method is used to post/upload files into the google cloud com.example.printit.firebase
     * @param file variable shall contain multipart file to be uploaded
     * @return success message on uploading the file
     * @throws Exception
     */
    @PostMapping("/upload-image")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return firebaseService.uploadFile(file);
    }



}