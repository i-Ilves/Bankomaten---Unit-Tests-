import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankomatTest {

    @Test
    void cardIsInserted() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        Assertions.assertEquals(true, bankomat.cardInserted);
    }

    @Test
    void cardIsNotInserted() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        bankomat.ejectCard();
        Assertions.assertEquals(false, bankomat.cardInserted);
    }

    @Test
    void correctPinEntered() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        boolean result = bankomat.enterPin("0123");
        Assertions.assertEquals(true, result);
    }

    @Test
    void incorrectPinEntered() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        boolean result = bankomat.enterPin("5123");
        Assertions.assertEquals(false, result);

    }
    @Test
    void getBalance() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        Account account = new Account();
        int result = account.balance;
        Assertions.assertEquals(account.balance, result);
    }

    @Test
    void withdrawMoneySucessful() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        boolean result = bankomat.enterPin("0123");
        int withdrawal = 5000;
        int machineBalanceBeforeWithdrawal = bankomat.machineBalance;
        int money = bankomat.withdrawMoney(withdrawal);
        Assertions.assertEquals(withdrawal, money);
        Assertions.assertEquals(machineBalanceBeforeWithdrawal - withdrawal, bankomat.machineBalance);
    }

    @Test
    void withdrawMoneyRejected() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        bankomat.insertCard(card);
        boolean result = bankomat.enterPin("0123");
        int withdrawal = 2000000;
        int money = bankomat.withdrawMoney(withdrawal);
        Assertions.assertEquals(0, money);
    }


}
