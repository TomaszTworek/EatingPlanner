package pl.tworek.EatingPlanner.images.infrastructures.adapters.primary.api;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.tworek.EatingPlanner.images.infrastructures.adapters.primary.api.response.ResponseMessage;
import pl.tworek.EatingPlanner.images.infrastructures.adapters.secondary.repository.ImageRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ImageController {

    private final ImageRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
                                    @RequestParam String recipeImageRequest) {
        String responseMessage = "";
        try {
            imageRepository.save(file, recipeImageRequest);
            responseMessage = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(responseMessage));
        } catch (Exception e) {
            responseMessage = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(responseMessage));
        }
    }

    @GetMapping("/files/{name}")
    public ResponseEntity<?> getFileByName(@PathVariable String name) {
        try {
            String newName = name + ".jpg";
            final Path imagePath = imageRepository.getImageByName(newName);

            if (imagePath != null) {

                final ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(imagePath));

                return ResponseEntity
                        .ok()
                        .contentLength(imagePath.toFile().length())
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
