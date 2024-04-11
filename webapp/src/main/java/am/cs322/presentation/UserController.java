package am.cs322.presentation;

import am.cs322.model.UserDTO;
import am.cs322.presentation.modal.CreateUserRequest;

public interface UserController {

    public UserDTO createUser(CreateUserRequest request);

}
