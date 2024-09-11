public class DebitAccount extends Account
{
    DebitAccount(){
        super();
    }
    DebitAccount(double promo){
        setBalance(promo);
    }
    @Override
    public boolean deposit(double _amount) {
        if(_amount <= 0){
            System.out.println("Incorrect Amount. Value is less than or equal to 0. ");
            return false;
        }
        setBalance(getBalance() + _amount);
        /*
        * double _balance = getBalance();
        * _balance = _balance + _amount;
        * setBalance(_balance)
        * */
        return true;
    }

    @Override
    public boolean withdraw(double _amount) {
        if(_amount > getBalance()){
            System.out.println("The amount: $" + _amount + " exceeds your balance.");
        return false;
        }
        if(_amount <= 0){
            System.out.println("You cannot withdraw money less than or equal to $0");
            return false;
        }
        double _balance = getBalance();
        _balance = _balance - _amount;
        setBalance(_balance);
        return true;
    }

    @Override
    public String toString() {
        String content = "DEBIT ACCOUNT\nBalance: $" + getBalance() + "\n";
        return content;
    }
}
