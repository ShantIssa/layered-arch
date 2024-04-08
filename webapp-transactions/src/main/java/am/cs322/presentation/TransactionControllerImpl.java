package am.cs322.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import am.cs322.TransactionService;
import am.cs322.presentation.modal.CreateTransactionRequest;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionControllerImpl implements TransactionController {

    TransactionService transactionService;

    public TransactionControllerImpl(TransactionService transaction) {
        this.transactionService = transaction;
    }

    @PostMapping("credit")
    public String initializeCreditAccount(@RequestBody CreateTransactionRequest request) {
        boolean value = transactionService.initializeCreditAccount(request.user_id());

        if (value) {
            return "Implemented a Credit Account";
        } else {
            return "Did not manage to create a Credit account";
        }
    }

    @PostMapping("debit")
    public String initializeDebitAccount(@RequestBody CreateTransactionRequest request) {
        boolean value = transactionService.initializeDebitAccount(request.user_id());

        if (value) {
            return "Implemented a Debit Account";
        } else {
            return "Did not manage to create a Debit account";
        }
    }
}