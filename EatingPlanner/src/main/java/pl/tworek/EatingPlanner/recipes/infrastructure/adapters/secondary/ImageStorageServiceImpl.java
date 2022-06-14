package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageStorageServiceImpl implements ImageStorageService {

    @Value(value = "${image.store.directory}")
    private String IMAGE_PATH;

    public ImageStorageServiceImpl() {
    }

    @Override
    public void save(MultipartFile file, FileInfo fileInfo) {
        try (InputStream is = file.getInputStream()) {
            final String newFilename = fileInfo.getFilename() + fileInfo.getExtension(); // Give a random filename here.
            Path root = Paths.get(IMAGE_PATH);
            Files.copy(is, root.resolve(newFilename));
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Path getImageByName(String name) {
        final Path root = Paths.get(IMAGE_PATH);
        return root.resolve(name);
    }

}
