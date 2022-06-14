package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FileInfo {
    String filename;
    String extension;
}
