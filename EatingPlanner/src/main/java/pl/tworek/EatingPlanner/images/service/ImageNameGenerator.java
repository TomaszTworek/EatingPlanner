package pl.tworek.EatingPlanner.images.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageNameGenerator {

    String generate(MultipartFile file, String recipeInfo);
}
