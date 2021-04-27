public class Bankomat {

    boolean cardInserted = false;
    Card card;
    boolean validCard;
    int machineBalance = 11000;

    void insertCard(Card card) {
        cardInserted = true;
        this.card = card;
    }

    public void ejectCard() {
        cardInserted = false;
    }

    boolean enterPin(String pin) {
        if (card.pin == pin) {
            return true;
        } else {
            return false;
        }
    }

    public int getBalance(Account account) {
        return account.balance;
    }

    public int withdrawMoney(int amount) {
            //Account account = new Account();
        if (card.balance >= amount && amount <= machineBalance) {
            card.balance  -= amount;
            machineBalance -= amount;
            System.out.println("Success! Account balance after withdraw: " + card.balance );
            return amount;
        } else {
            System.out.println("Denied. Account balance: " + card.balance  + ", Machine balance: " + machineBalance);
            System.out.println("Your attempt at withdrawal: " + amount);
            return 0;
        }

/*    public boolean withdrawMoney(int amount) {
        Account account = new Account();
        if (account.balance >= amount && amount <= machineBalance) {
            account.balance  -= amount;
            machineBalance -= amount;
            System.out.println("Account balance after withdraw: " + account.balance );
            return true;
        } else {
            System.out.println("Denied. Account balance: " + account.balance  + ", Machine balance: " + machineBalance);
            System.out.println("Your attempt at withdrawal: " + amount);
            return false;
        }
    }*/


    }
}