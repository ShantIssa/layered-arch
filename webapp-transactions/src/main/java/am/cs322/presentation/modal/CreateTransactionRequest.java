package am.cs322.presentation.modal;

import jakarta.annotation.Nonnull;

public record CreateTransactionRequest(@Nonnull
                                       Long user_id) {
}