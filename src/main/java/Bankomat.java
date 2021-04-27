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


    }

    public int transferMoneyToAccount(int money, Card card) {
        int cardBalanceBeforeTransfer = card.balance;
        int cardBalanceAfterTransfer = (card.balance += money);
        System.out.println("Card balance before transfer: " + cardBalanceBeforeTransfer);
        System.out.println("Card balance after transfer: " + cardBalanceAfterTransfer);
        card.balance = cardBalanceAfterTransfer;
        return card.balance;
    }
}