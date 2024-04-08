package am.cs322.model;

public class TransactionDTO {
    private Long userId;
    private String fullName;
    private TransactionType type;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type == TransactionType.DEBIT ? "debit" : "credit";
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
