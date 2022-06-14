package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.ResponseMessage;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.FileInfo;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    private final ImageStorageService storageService;

    public ImageController(ImageStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                                      @RequestParam String recipeImageRequest) {
        String message = "";
        try {
            int i = file.getOriginalFilename().lastIndexOf(".");
            String extension = file.getOriginalFilename().substring(i);
            FileInfo fileInfo = FileInfo.builder()
                    .filename(recipeImageRequest)
                    .extension(extension).build();
            storageService.save(file, fileInfo);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            System.out.println(e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{name}")
    public ResponseEntity<?> getFileByName(@PathVariable String name) {
        try {
            String newName = name + ".jpg";
            final Path imagePath = storageService.getImageByName(newName);

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
