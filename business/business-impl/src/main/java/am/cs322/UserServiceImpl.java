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
        return new UserDTO(String.join(" ", user.getFirstName(), user.getLastName()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(String.join(" ", user.getFirstName(), user.getLastName())))
                .collect(Collectors.toList());
    }
}
