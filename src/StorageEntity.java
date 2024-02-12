/**
 * Storage entity for folder and file
 */
public abstract class StorageEntity implements Cloneable {
    /**
     * Name
     */
    public String name;

    /**
     * Constructor with name
     * @param name Name of the entity
     */
    public StorageEntity(String name) {
        this.name = name;
    }

    /**
     * Clone
     */
    @Override
    public abstract StorageEntity clone();

    /**
     * Display
     */
    public abstract void display();

    /**
     * Display
     * @param prefix Prefix for display; default is ""
     */
    public abstract void display(String prefix);
}
