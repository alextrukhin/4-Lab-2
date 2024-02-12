/**
 * File class
 */
public class File extends StorageEntity {
    /**
     * Constructor with name
     * @param name Name of the file
     */
    public File(String name) {
        super(name);
    }

    /**
     * Clone
     */
    @Override
    public StorageEntity clone() {
        return new File(this.name);
    }

    /**
     * Display Primitive
     */
    @Override
    public void display() {
        this.display("");
    }

    /**
     * Display Primitive
     */
    @Override
    public void display(String prefix) {
        System.out.println(prefix + this.name);
    }
}
