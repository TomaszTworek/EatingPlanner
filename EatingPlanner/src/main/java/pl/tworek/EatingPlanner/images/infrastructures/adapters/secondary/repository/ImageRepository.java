package pl.tworek.EatingPlanner.images.infrastructures.adapters.secondary.repository;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface ImageRepository {

    void save(MultipartFile multipartImage, String imageName);

    Path getImageByName(String filename);

}
