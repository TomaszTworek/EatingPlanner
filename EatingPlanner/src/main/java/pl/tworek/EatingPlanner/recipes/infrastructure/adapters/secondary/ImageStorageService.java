package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ImageStorageService {

    void save(MultipartFile multipartImage);

    Resource load(String filename);

    public Stream<Path> loadAll();
}
