package actions;

public class AdvanceAndRemember implements IAction {

    private String key;
    private String value;

    public AdvanceAndRemember(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getActionString() {
        return "advance_and_remember";
    }
}
