package org.com.estudos.hexagonal.domain.usecase.user.registerUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.com.estudos.hexagonal.application.gateway.input.RegisterUserInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterUserOutput;
import org.com.estudos.hexagonal.domain.entity.User;
import org.com.estudos.hexagonal.domain.port.inbound.RegisterUserUsecase;
import org.com.estudos.hexagonal.domain.port.outbound.repository.UserRepositoryPort;
import org.com.estudos.hexagonal.domain.port.outbound.utils.EmailValidatorUtilsPort;
import org.com.estudos.hexagonal.domain.usecase.user.registerUser.exception.UserAlreadyExistsException;

import java.util.Optional;

@AllArgsConstructor
@Builder
public class RegisterUserUsecaseImpl implements RegisterUserUsecase {
    private final UserRepositoryPort userRepositoryPort;
    private final EmailValidatorUtilsPort emailValidatorUtilsPort;

    @Override
    public RegisterUserOutput execute(RegisterUserInput input) {
        validateEmail(input.getEmail());
        checkUserExists(input);
        User userFilled = fillUser(input);
        userFilled = persistUser(userFilled);

        return mountOutput(userFilled);
    }

    private void validateEmail(String email) {
        emailValidatorUtilsPort.validate(email);
    }

    private void checkUserExists(RegisterUserInput input) {
        Optional<User> user = userRepositoryPort.findByEmail(input.getEmail());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
        }
    }

    private User fillUser(RegisterUserInput input) {
        return User.builder()
            .name(input.getName())
            .email(input.getEmail())
            .build();
    }

    private User persistUser(User user) {
        return userRepositoryPort.save(user);
    }

    private RegisterUserOutput mountOutput(User user) {
        return RegisterUserOutput.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .build();
    }
}
