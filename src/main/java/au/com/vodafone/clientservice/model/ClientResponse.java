package au.com.vodafone.clientservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    @Schema(description = "Client id", example = "1234")
    private long id;

    private String name;

    private String email;
}
