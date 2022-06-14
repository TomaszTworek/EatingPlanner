package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface ImageStorageService {

    void save(MultipartFile multipartImage, FileInfo recipeInfo);

    Path getImageByName(String filename);

}
