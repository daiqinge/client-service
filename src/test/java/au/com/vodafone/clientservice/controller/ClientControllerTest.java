package au.com.vodafone.clientservice.controller;

import au.com.vodafone.clientservice.model.ClientRequest;
import au.com.vodafone.clientservice.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
  private ClientController controller;

  @Mock
  private ClientService clientService;

  @BeforeEach
  public void setup() {
    controller = new ClientController(clientService);
  }

  @Test
  public void should_save_client() {
    ClientRequest request = new ClientRequest();

    given(clientService.addUser(request)).willReturn("OK");

    String actual = controller.addUser(request);

    assertThat(actual).isEqualTo("OK");
  }

}
