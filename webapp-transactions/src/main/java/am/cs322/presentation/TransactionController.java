package am.cs322.presentation;


import am.cs322.presentation.modal.CreateTransactionRequest;

public interface TransactionController {

    String initializeCreditAccount(CreateTransactionRequest request);

    String initializeDebitAccount(CreateTransactionRequest request);
}
