package com.i0xnaveen.youtube.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;
@Document(value = "Video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    private String id;
    private String description;
    private String title;
    private String userId;
    private Integer likes;
    private Integer disLikes;
    private Set<String> tags;
    private String videoUrl;
    private VideoStatus videoStatus;
    private  Integer viewCount;
    private String thumbnailUrl;
    private List<Comment> commentList;
}
