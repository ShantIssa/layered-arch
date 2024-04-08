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

    /**
     * Retrieves a list of all users.
     *
     * @return A list of UserDTO objects representing all users.
     */
    @GetMapping
    public List<UserDTO>getUsers() {
        return userService.getUsers();
    }

    /**
     * Creates a new user based on the provided request body.
     *
     * @param request The CreateUserRequest containing the first and last name.
     * @return The created UserDTO.
     */
    @Override
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.firstName(), request.lastName());
    }
}