package xyz.michaelobi.toggleton.togglestate;

public abstract class ToggleState<T> {
    private String key;
    private T toDisplay; // Ridiculous name. I sure can do better

    public ToggleState(String key, T toDisplay) {
        this.key = key;
        this.toDisplay = toDisplay;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getResourceToDisplay() {
        return toDisplay;
    }

    public void setResourceToDisplay(T toDisplay) {
        this.toDisplay = toDisplay;
    }

    @Override
    public String toString() {
        return String.format("State: key = %s Resource to display: %s", key, toDisplay.toString());
    }


}
