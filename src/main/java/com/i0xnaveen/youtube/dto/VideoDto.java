package com.i0xnaveen.youtube.dto;

import com.i0xnaveen.youtube.model.Comment;
import com.i0xnaveen.youtube.model.VideoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {
    private String id;
    private String description;
    private String title;
    private Set<String> tags;
    private String videoUrl;
    private VideoStatus videoStatus;
    private String thumbnailUrl;
}
