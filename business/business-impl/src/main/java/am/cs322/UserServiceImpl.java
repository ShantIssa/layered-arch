package am.cs322;

import am.cs322.model.UserDTO;
import am.cs322.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createUser(String firstName, String lastName) {
        UserEntity user = userRepository.save(new UserEntity(firstName, lastName));
        return new UserDTO(user.getFirstName() +" " +user.getLastName());
    }

    public List<UserDTO>getAllUsers() {
        List<UserEntity> users  = userRepository.findAll();
        // Using Java streams to transform UserEntity objects into UserDTO objects

        return users.stream()
                .map(userEntity -> {
                    return new UserDTO(userEntity.getFirstName() +" " +userEntity.getLastName());
                }).collect(Collectors.toList());
    }
}