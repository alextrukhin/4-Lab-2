public class File extends StorageEntity {
    public File(String name) {
        super(name);
    }


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
