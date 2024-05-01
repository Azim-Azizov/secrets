package az.kapitalbank.secrets.controller;

import az.kapitalbank.secrets.model.request.SecretRequest;
import az.kapitalbank.secrets.model.response.SecretResponse;
import az.kapitalbank.secrets.service.SecretService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/secrets")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SecretController {

    SecretService service;

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public SecretResponse getSecret(@PathVariable Long id) {
        return service.getSecret(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public SecretResponse saveSecret(@RequestBody SecretRequest secret) {
        return service.saveSecret(secret);
    }
}