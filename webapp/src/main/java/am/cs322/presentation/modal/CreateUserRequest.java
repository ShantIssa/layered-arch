package am.cs322.presentation.modal;

import jakarta.annotation.Nonnull;

public record CreateUserRequest(@Nonnull
                                String firstName,
                                @Nonnull
                                String lastName) {
}
