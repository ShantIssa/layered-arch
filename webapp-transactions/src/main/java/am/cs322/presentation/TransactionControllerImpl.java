package am.cs322.presentation;

import am.cs322.TransactionService;
import am.cs322.presentation.modal.CreateTransactionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionControllerImpl implements TransactionController {


    TransactionService transactionService;

    public TransactionControllerImpl(TransactionService tS) {
        this.transactionService = tS;
    }

    @PostMapping("credit")
    public String createCreditAccount(@RequestBody CreateTransactionRequest request) {
        boolean value = transactionService.createCreditAccount(request.user_id());

        return value ? "Created a Credit Account" : "Creation is Not Done";
    }

    @PostMapping("debit")
    public String createDebitAccount(@RequestBody CreateTransactionRequest request) {
        boolean value = transactionService.createDebitAccount(request.user_id());

        return value ? "Created a Debit Account" : "Creation is Not Done";
    }
}