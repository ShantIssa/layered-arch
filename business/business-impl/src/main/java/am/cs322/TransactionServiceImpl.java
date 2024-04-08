package am.cs322;

import am.cs322.model.AccountsEntity;
import am.cs322.model.TransactionType;
import am.cs322.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{
    TransactionRepository transactionRepository;
    UserRepository userRepository;

    public TransactionServiceImpl(TransactionRepository rs, UserRepository us) {
        transactionRepository = rs;
        userRepository = us;
    }
    @Override
    public boolean createDebitAccount(Long user_id) {
        Optional<UserEntity> user = userRepository.findById(user_id);
        user.ifPresent(userEntity -> transactionRepository.save(new AccountsEntity(TransactionType.debit, userEntity)));

        return user.isPresent();
    }

    @Override
    public boolean createCreditAccount(Long user_id) {
        Optional<UserEntity> user = userRepository.findById(user_id);
        user.ifPresent(userEntity -> transactionRepository.save(new AccountsEntity(TransactionType.credit, userEntity)));

       return user.isPresent();
    }
}
