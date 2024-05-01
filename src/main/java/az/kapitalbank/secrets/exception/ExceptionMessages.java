package az.kapitalbank.secrets.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public enum ExceptionMessages {
    UNEXPECTED_ERROR("Unexpected error occurred!"),
    SECRET_NOT_EXISTS_ERROR_WITH_ID("Secret does not exists with ID: %d"),
    SECRET_ALREADY_EXISTS_ERROR_WITH_NAME("Secret already exists with key: %s");
    String message;
}