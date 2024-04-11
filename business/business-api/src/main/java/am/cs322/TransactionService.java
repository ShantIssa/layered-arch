package am.cs322;

public interface TransactionService {
    boolean initializeDebitAccount(Long user_id);

    boolean initializeCreditAccount(Long user_id);
}
