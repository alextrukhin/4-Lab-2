/**
 * Entry point of the program
 */
public class Main {
    /**
     * Display
     *
     * @param entity   Entity (folder or file)
     * @param previews File preview factory
     * @param args     Depth
     */
    public static void display(StorageEntity entity, FilePreviewFactory previews, int... args) {
        int i = args.length > 0 ? args[0] : 0;
        System.out.println(new String(new char[i]).replace("\0", "  ") + "Folder: " + entity.name);
        if (entity instanceof File) {
            previews.getFilePreview((File) entity).display(new String(new char[i + 1]).replace("\0", "  "));
            return;
        }
        for (StorageEntity n : ((Folder) entity).nodes) {
            if (n instanceof File) {
                previews.getFilePreview((File) n).display(new String(new char[i + 1]).replace("\0", "  "));
            } else {
                display(n, previews, i + 1);
                i++;
            }
        }
    }

    /**
     * Main
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        FilePreviewFactory previews = new FilePreviewFactory();
        File file1 = new File("red.txt");
        File file2 = new File("blue.png");
        File file3 = new File("green.jpg");
        root.add(file1);
        root.add(file2);
        root.add(file3);
        display(root, previews);
        root.remove(file3);
        root.add(root.clone());
        display(root, previews);
    }
}