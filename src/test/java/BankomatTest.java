import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BankomatTest {

    @Disabled
    @Test
    void testtest(){
        Assertions.assertEquals(1,1);
    }

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
    void getBalance() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        Account account = new Account();
        int result = account.balance;
        Assertions.assertEquals(account.balance, result);
    }

    @Test
    void withdrawMoney() {
        Bankomat bankomat = new Bankomat();
        Card card = new Card();
        Account account = new Account();
        boolean result = bankomat.withdrawMoney(1100);
        Assertions.assertEquals(true, result);
    }
}
