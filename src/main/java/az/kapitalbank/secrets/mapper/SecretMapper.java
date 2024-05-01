package az.kapitalbank.secrets.mapper;

import az.kapitalbank.secrets.dao.entity.SecretEntity;
import az.kapitalbank.secrets.model.request.SecretRequest;
import az.kapitalbank.secrets.model.response.SecretResponse;

public enum SecretMapper {
    SECRET_MAPPER;

    public SecretEntity mapRequestToEntity(SecretRequest request) {
        return SecretEntity.builder()
                .key(request.getKey())
                .value(request.getValue())
                .build();
    }

    public SecretResponse mapEntityToResponse(SecretEntity entity) {
        return SecretResponse.builder()
                .id(entity.getId())
                .key(entity.getKey())
                .value(entity.getValue())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}