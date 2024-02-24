package com.i0xnaveen.youtube.service;

import com.i0xnaveen.youtube.Repository.videoRepository;
import com.i0xnaveen.youtube.dto.VideoDto;
import com.i0xnaveen.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final videoRepository videoRepository;

    public  String  uploadVideo(MultipartFile multipartFile) throws IOException {
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setVideoUrl(videoUrl);

        videoRepository.save(video);
        return videoUrl;
    }

    public VideoDto editVideo(VideoDto videoDto) {
        Video saveVideo=videoRepository.findById(videoDto.getId()).orElseThrow(()->
            new IllegalArgumentException("cannot find id"));
        saveVideo.setTitle(videoDto.getTitle());
        saveVideo.setDescription(videoDto.getDescription());
        saveVideo.setTags(videoDto.getTags());
        saveVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
        saveVideo.setVideoStatus(videoDto.getVideoStatus());
        videoRepository.save(saveVideo);
        return videoDto;


    }

    public String uploadThumbnail(MultipartFile file,String videoId) throws IOException {
        String thumbnailUrl=s3Service.uploadFile(file);
        Video video=videoRepository.findById(videoId).orElseThrow();
        video.setThumbnailUrl(thumbnailUrl);
        videoRepository.save(video);
        return thumbnailUrl;


    }
}
