package pl.tworek.EatingPlanner.images.service;

import org.springframework.web.multipart.MultipartFile;

public class ImageNameGeneratorImpl implements ImageNameGenerator {

    @Override
    public String generate(MultipartFile file, String recipeName) {
        int indexOfExtension = -1;
        String extension = "";
        if (file.getOriginalFilename() != null) {
            indexOfExtension = file.getOriginalFilename().lastIndexOf(".");
            extension = file.getOriginalFilename().substring(indexOfExtension);
        }
        return recipeName + extension;
    }
}
