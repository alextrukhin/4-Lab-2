public abstract class StorageEntity implements Cloneable {
    /**
     * Name
     */
    public String name;

    /**
     * Constructor with name
     */
    public StorageEntity(String name) {
        this.name = name;
    }

    @Override
    public abstract StorageEntity clone();

    /**
     * Display
     */
    public abstract void display();

    /**
     * Display
     */
    public abstract void display(String prefix);
}
