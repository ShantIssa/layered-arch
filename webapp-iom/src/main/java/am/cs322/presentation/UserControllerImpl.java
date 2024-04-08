package am.cs322.presentation;

import am.cs322.UserService;
import am.cs322.model.UserDTO;
import am.cs322.presentation.modal.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDTO>getUsers() {
        return userService.getUsers();
    }

    @Override
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.firstName(), request.lastName());
    }
}