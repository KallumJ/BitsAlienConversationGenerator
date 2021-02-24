package actions;

public class PayAndAdvance implements IAction {
    private final String item;

    public PayAndAdvance(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String getActionString() {
        return "pay_and_advance";
    }
}
