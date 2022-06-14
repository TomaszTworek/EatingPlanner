package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeImageRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageService;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.ImageStorageServiceImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeApiService recipeApiService;

    public RecipeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @PostMapping
    public RecipeResponse saveRecipe(@RequestBody RecipeRequest recipeRequest) {
        System.out.println(recipeRequest);
        return recipeApiService.save(recipeRequest);
    }

    @GetMapping("/all")
    public List<RecipeResponse> getAllRecipes(){
        return recipeApiService.getAll();
    }

    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
}
//    @GetMapping("/files")
//    public ResponseEntity<List<FileInfo>> getListFiles() {
//        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
//            String filename = path.getFileName().toString();
//            String url = MvcUriComponentsBuilder
//                    .fromMethodName(ImageController.class, "getFile", path.getFileName().toString()).build().toString();
//            return FileInfo.builder().filename(filename).build();
//        }).collect(Collectors.toList());
//        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
//    }