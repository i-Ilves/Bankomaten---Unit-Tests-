import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankomatScenariosTest {

    Bankomat bankomat;
    Card card;

    @Test
    @DisplayName("Scenario 1")
    void scenario1(){
        bankomat = new Bankomat();
        card = new Card();
        bankomat.insertCard(card);
        cardIsInserted();
        boolean pinResult = bankomat.enterPin("1234");
        incorrectPinEntered(pinResult);
        pinResult = bankomat.enterPin("0123");
        correctPinEntered(pinResult);
        int withdrawal = 5000;
        int machineBalanceBeforeWithdrawal = bankomat.machineBalance;
        int money = bankomat.withdrawMoney(withdrawal);
        moneyWithdrawalSuccessful(withdrawal, money, machineBalanceBeforeWithdrawal);
        bankomat.ejectCard();
    }

    @Test
    @DisplayName("Scenario 2")
    void scenario2() {
        bankomat = new Bankomat();
        card = new Card();
        bankomat.insertCard(card);
        cardIsInserted();
        boolean pinResult = bankomat.enterPin("1234");
        incorrectPinEntered(pinResult);
        pinResult = bankomat.enterPin("0123");
        correctPinEntered(pinResult);
        int withdrawal = 200000;
        int money = bankomat.withdrawMoney(withdrawal);
        int machineBalanceBeforeWithdrawal = bankomat.machineBalance;
        moneyWithdrawalRejected(0, money);
        int newWithdrawal = 6000;
        int money1 = bankomat.withdrawMoney(newWithdrawal);
        moneyWithdrawalSuccessful(newWithdrawal, money1, machineBalanceBeforeWithdrawal);
        bankomat.ejectCard();
    }

    void cardIsInserted(){
        Assertions.assertEquals(true, bankomat.cardInserted);
    }


    void cardIsNotInserted(){
        bankomat.insertCard(card);
        bankomat.ejectCard();
        Assertions.assertEquals(false, bankomat.cardInserted);
    }


    void correctPinEntered(boolean pinResult){
        Assertions.assertEquals(true, pinResult);
    }


    void incorrectPinEntered(boolean pinResult){
        Assertions.assertEquals(false, pinResult);
    }


    void moneyWithdrawalSuccessful(int withdrawal, int money, int machineBalanceBeforeWithdrawal){
        Assertions.assertEquals(withdrawal, money);
        Assertions.assertEquals(machineBalanceBeforeWithdrawal - withdrawal, bankomat.machineBalance);
    }


    void moneyWithdrawalRejected(int withdrawal, int money){
        Assertions.assertEquals(0, money);
    }

}
