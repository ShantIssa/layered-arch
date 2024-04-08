package am.cs322.presentation;


import am.cs322.presentation.modal.CreateTransactionRequest;

public interface TransactionController {

    String createCreditAccount(CreateTransactionRequest request);

    String createDebitAccount(CreateTransactionRequest request);
}
