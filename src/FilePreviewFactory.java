import java.util.HashMap;
import java.util.Map;

/**
 * Uses flyweight pattern to create file preview objects
 */
public class FilePreviewFactory {
    /**
     * Constructor
     */
    public FilePreviewFactory() {

    }
    /**
     * File preview map
     */
    private final Map<String, FilePreview> filePreviewMap = new HashMap<>();
    /**
     * Default file preview
     */
    private final FilePreview defaultFilePreview = new FilePreview("");

    /**
     * Get file preview
     *
     * @param file File
     * @return File preview
     */
    public FilePreview getFilePreview(StorageEntity file) {
        FilePreview filePreview = filePreviewMap.get(file.name);
        if (!(file instanceof File)) {
            return defaultFilePreview;
        }
        if (filePreview == null) {
            try {
                filePreview = new FilePreview((File) file);
            } catch (IllegalArgumentException e) {
                filePreview = defaultFilePreview;
            }
            filePreviewMap.put(file.name, filePreview);
        }
        return filePreview;
    }
}
