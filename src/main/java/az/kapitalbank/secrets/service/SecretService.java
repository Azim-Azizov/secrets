package az.kapitalbank.secrets.service;

import az.kapitalbank.secrets.dao.entity.SecretEntity;
import az.kapitalbank.secrets.dao.repository.SecretRepository;
import az.kapitalbank.secrets.exception.AlreadyExistsException;
import az.kapitalbank.secrets.exception.NotExistsException;
import az.kapitalbank.secrets.model.request.SecretRequest;
import az.kapitalbank.secrets.model.response.SecretResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static az.kapitalbank.secrets.exception.ExceptionMessages.SECRET_ALREADY_EXISTS_ERROR_WITH_NAME;
import static az.kapitalbank.secrets.exception.ExceptionMessages.SECRET_NOT_EXISTS_ERROR_WITH_ID;
import static az.kapitalbank.secrets.mapper.SecretMapper.SECRET_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SecretService {

    SecretRepository repository;

    public SecretResponse getSecret(Long id) {
        return SECRET_MAPPER.mapEntityToResponse(getSecretByIdIfExists(id));
    }

    public SecretResponse saveSecret(SecretRequest request) {
        if (isSecretExists(request.getKey()))
            throw new AlreadyExistsException(SECRET_ALREADY_EXISTS_ERROR_WITH_NAME.getMessage().formatted(request.getKey()));
        return SECRET_MAPPER.mapEntityToResponse(repository.save(SECRET_MAPPER.mapRequestToEntity(request)));
    }

    private Boolean isSecretExists(String key) {
        return repository.existsByKey(key);
    }

    private SecretEntity getSecretByIdIfExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotExistsException(SECRET_NOT_EXISTS_ERROR_WITH_ID.getMessage().formatted(id)));
    }
}