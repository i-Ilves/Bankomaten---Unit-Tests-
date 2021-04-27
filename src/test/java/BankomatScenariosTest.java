import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankomatScenariosTest {

    Bankomat bankomat;
    Card card;

    /*
     **Scenario 1**

     *   Sätt in ett kort i bankomaten. (Bankomaten ska veta att ett kort är inne)
     *   Mata in den felaktiga pinkoden 1234 i bankomaten. (Pinkoden ska vara sparad på kortet, men det är bankomaten som ska veta om rätt eller fel kod matats in)
     *   Mata in den korrekta pinkoden 0123.
     *  Ange 5000 kr att ta ut via bankomaten. Balansen ska tas från kontot som är kopplat till kortet.
     *  Mata ut kortet ur bankomaten.
     */
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


    void moneyWithdrawalRejected(){

        int withdrawal = 9999999;
        int money = bankomat.withdrawMoney(withdrawal);
        Assertions.assertEquals(0, money);
    }

}
