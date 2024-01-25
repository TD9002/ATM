package srhe.dittmar.ui;

public class TransferUI extends Menu {
    private final String MENU_NAME = "Transfer";

    public TransferUI() {
        super.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        System.out.println("--------" + MENU_NAME + "--------");
    }
}