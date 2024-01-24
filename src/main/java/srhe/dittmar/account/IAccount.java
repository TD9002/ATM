package srhe.dittmar.account;

public interface IAccount {

    public boolean withdraw (int amount);
    public boolean deposit (int amount);
    public boolean transfer();
    public boolean printAccount();
    public boolean showAccountState();
}
