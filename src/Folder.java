import java.util.ArrayList;
import java.util.List;

/**
 * Folder
 */
public class Folder extends StorageEntity {
    /**
     * Prefix for display method
     */
    public final String prefix = "  ";
    /**
     * List of figures
     */
    public List<StorageEntity> nodes = new ArrayList<>();

    /**
     * Constructor
     * @param name Name of the folder
     */
    public Folder(String name) {
        super(name);
    }

    /**
     * Add node
     *
     * @param node Figure to add
     */
    public void add(StorageEntity node) {
        nodes.add(node);
    }

    /**
     * Remove node
     *
     * @param node Figure to remove
     */
    public void remove(StorageEntity node) {
        nodes.remove(node);
    }

    /**
     * Clone
     */
    @Override
    public StorageEntity clone() {
        Folder folder = new Folder(this.name);
        for (StorageEntity n : nodes) {
            folder.add(n.clone());
        }
        return folder;
    }

    /**
     * Display Composition
     */
    @Override
    public void display() {
        this.display("");
    }

    /**
     * Display Composition
     */
    @Override
    public void display(String prefix) {
        System.out.println(prefix + "Folder: " + this.name);
        for (StorageEntity n : nodes) {
            n.display(prefix + prefix + this.prefix);
        }
    }
}
