package am.cs322.model;

public class TransactionDTO {
    private Long userId;
    private String fullName;

    private TransactionType type;

    public Long getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        if (TransactionType.debit == type) {
            return "debit";
        }

        return "credit";
    }
}
