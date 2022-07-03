package pl.tworek.EatingPlanner.images.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tworek.EatingPlanner.images.infrastructures.adapters.secondary.repository.ImageRepository;
import pl.tworek.EatingPlanner.images.infrastructures.adapters.secondary.repository.ImageRepositoryImpl;
import pl.tworek.EatingPlanner.images.service.ImageNameGenerator;
import pl.tworek.EatingPlanner.images.service.ImageNameGeneratorImpl;

@Configuration
public class ImageConfiguration {

    @Bean
    public ImageRepository imageRepository() {
        return new ImageRepositoryImpl(imageNameGenerator());
    }

    private ImageNameGenerator imageNameGenerator() {
        return new ImageNameGeneratorImpl();
    }
}
