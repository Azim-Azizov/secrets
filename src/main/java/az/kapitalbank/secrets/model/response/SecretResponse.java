package az.kapitalbank.secrets.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SecretResponse {
    Long id;
    String key;
    String value;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}