package az.kapitalbank.secrets.dao.repository;

import az.kapitalbank.secrets.dao.entity.SecretEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SecretRepository extends CrudRepository<SecretEntity, Long> {
    boolean existsByKey(String key);

    Optional<SecretEntity> findBykey(String key);

}