/**
 * FilePreview
 */
public class FilePreview {
    private static final String WINDOWS_FILE_SEPARATOR = "\\";
    private static final String UNIX_FILE_SEPARATOR = "/";
    private static final String FILE_EXTENSION = ".";
    public String buffer;

    public FilePreview(File file) {
        this.buffer = generatePreview(file);
    }

    public FilePreview(String buffer) {
        this.buffer = buffer;
    }

    /**
     * Get file extension
     * {@code @source} <a href="https://www.baeldung.com/java-file-extension">...</a>
     *
     * @param fileName File name
     * @return File extension
     */
    public static String getFileExtensionImproved(String fileName) {

        if (fileName == null) {
            throw new IllegalArgumentException("fileName must not be null!");
        }

        String extension = "";

        int indexOfLastExtension = fileName.lastIndexOf(FILE_EXTENSION);

        // check last file separator, windows and unix
        int lastSeparatorPosWindows = fileName.lastIndexOf(WINDOWS_FILE_SEPARATOR);
        int lastSeparatorPosUnix = fileName.lastIndexOf(UNIX_FILE_SEPARATOR);

        // takes the greater of the two values, which mean last file separator
        int indexOflastSeparator = Math.max(lastSeparatorPosWindows, lastSeparatorPosUnix);

        // make sure the file extension appear after the last file separator
        if (indexOfLastExtension > indexOflastSeparator) {
            extension = fileName.substring(indexOfLastExtension + 1);
        }

        return extension;

    }
    public static String generatePreview(File file) {
        return switch (getFileExtensionImproved(file.name)){
            case "" -> "Raw file: " + file.name;
            case "txt" -> "Text file: " + file.name;
            case "png", "jpg" -> "Image file: " + file.name;
            case "mp3" -> "Audio file: " + file.name;
            case "mp4" -> "Video file: " + file.name;
            default -> throw new IllegalArgumentException("Unknown file type: " + file.name);
        };
    }
    public void display(String prefix) {
        System.out.println(prefix + this.buffer);
    }
}
