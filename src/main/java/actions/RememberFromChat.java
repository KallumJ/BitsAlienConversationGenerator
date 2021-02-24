package actions;

public class RememberFromChat implements IAction {
    private final String key;

    public RememberFromChat(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String getActionString() {
        return "remember_from_chat";
    }
}
