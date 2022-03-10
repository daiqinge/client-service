package au.com.vodafone.clientservice.Service;

import au.com.vodafone.clientservice.controller.ClientController;
import au.com.vodafone.clientservice.model.ClientResponse;
import au.com.vodafone.clientservice.service.ClientRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

  private ClientService clientService;

  @Mock
  private ClientRepository clientRepository;

  Long testClientId = 123L;

  @BeforeEach
  public void setup() {
    clientService = new ClientService(clientRepository);
  }

  @Test
  public void should_get_client() {
    ClientResponse response = new ClientResponse();
    response.setId(testClientId);

    given(clientService.getClient(testClientId)).willReturn(response);

    ClientResponse actual  = clientService.getClient(testClientId);

    assertThat(actual.getId()).isEqualTo(response.getId());
  }
}
