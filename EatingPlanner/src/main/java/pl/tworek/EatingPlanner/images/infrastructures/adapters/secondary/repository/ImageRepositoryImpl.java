package pl.tworek.EatingPlanner.images.infrastructures.adapters.secondary.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import pl.tworek.EatingPlanner.images.service.ImageNameGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {

    private final ImageNameGenerator imageNameGenerator;

    @Value(value = "${image.store.directory}")
    private String IMAGE_PATH;

    @Override
    public void save(MultipartFile file, String imageName) {
        final String imageNewName = imageNameGenerator.generate(file, imageName);
        try (InputStream is = file.getInputStream()) {
            Path root = Paths.get(IMAGE_PATH);
            Files.copy(is, root.resolve(imageNewName));
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Path getImageByName(String name) {
        final Path root = Paths.get(IMAGE_PATH);
        return root.resolve(name);
    }

}
