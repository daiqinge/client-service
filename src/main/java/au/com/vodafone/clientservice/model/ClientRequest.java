package au.com.vodafone.clientservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    @Schema(description = "Client id", example = "1234")
    @Id
    private long id;

    private String name;

    private String email;
}
