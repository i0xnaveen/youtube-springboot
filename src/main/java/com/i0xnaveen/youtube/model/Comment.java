package com.i0xnaveen.youtube.model;

import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private String id;
    private String text;
    private String authorId;
    private Integer likeCount;
    private Integer disLikeCount;
}
