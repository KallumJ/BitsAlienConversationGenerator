package gui.components;

/**
 * An interface to implement behaviour to return the component being modelled
 *
 * @param <T> The type of JavaFX node being modelled
 */
public interface IComponent<T> {

    /**
     * Returns the component being modelled
     *
     * @return an instance of a JavaFX Node
     */
    T getComponent();
}
