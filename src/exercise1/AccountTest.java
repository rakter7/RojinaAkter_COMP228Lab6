package exercise1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(500);
        Account account2 = new Account(200);

        Transaction transaction1 = new Transaction("deposit", account1);
        Transaction transaction2 = new Transaction("withdraw", account2);
        Transaction transaction3 = new Transaction("deposit", account1);
        Transaction transaction4 = new Transaction("withdraw", account2);

        Transaction[] array = {transaction1, transaction2, transaction3, transaction4};

        for(int i=0; i<array.length; i++) {
            ExecutorService exService = Executors.newCachedThreadPool();

            exService.execute(transaction1);
            exService.execute(transaction2);

            exService.shutdown();
        }
    }

}

