package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ImageStorageServiceImpl implements ImageStorageService {

    private final Path root;

    {
        final String imagePath = "C:\\dev\\EatingPlanner - project\\EatingPlanner\\EatingPlanner\\src\\main\\resources\\static\\images";
        root = Paths.get(imagePath);
    }

    @Override
    public void save(MultipartFile multipartImage) {
        try {
            if (multipartImage.getOriginalFilename() == null) {
                throw new RuntimeException();
            }
            Files.copy(multipartImage.getInputStream(), this.root.resolve(multipartImage.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        final Path file = root.resolve(filename);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
