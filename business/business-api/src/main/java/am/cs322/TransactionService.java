package am.cs322;

public interface TransactionService {
    boolean createDebitAccount(Long user_id);

    boolean createCreditAccount(Long user_id);
}
