package am.cs322;

import am.cs322.model.AccountsEntity;
import am.cs322.model.TransactionType;
import am.cs322.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean initializeDebitAccount(Long userId) {
        return initializeAccount(userId, TransactionType.CREDIT);
    }

    @Override
    public boolean initializeCreditAccount(Long userId) {
        return initializeAccount(userId, TransactionType.DEBIT);
    }

    private boolean initializeAccount(Long userId, TransactionType type) {
        Optional<UserEntity> user = userRepository.findById(userId);
        user.ifPresent(u -> transactionRepository.save(new AccountsEntity(type, u)));
        return user.isPresent();
    }
}
