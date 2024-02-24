package com.i0xnaveen.youtube.Repository;

import com.i0xnaveen.youtube.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface videoRepository extends MongoRepository<Video,String> {
}
