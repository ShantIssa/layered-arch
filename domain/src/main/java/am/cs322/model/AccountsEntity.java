package am.cs322.model;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class AccountsEntity {
    public AccountsEntity() {

    }
    public AccountsEntity(TransactionType type, UserEntity user) {
        this.type = type;
        this.user = user;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
