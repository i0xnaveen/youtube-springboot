package com.i0xnaveen.youtube.controller;

import com.i0xnaveen.youtube.dto.VideoDto;
import com.i0xnaveen.youtube.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String  uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
       return videoService.uploadVideo(file);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editVideo(@RequestBody VideoDto videoDto){
       return    videoService.editVideo(videoDto);
    }
    @PostMapping("/thumbnail")
    @ResponseStatus(HttpStatus.CREATED)
        public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String VideoId) throws IOException {
           return videoService.uploadThumbnail(file,VideoId);

        }

}