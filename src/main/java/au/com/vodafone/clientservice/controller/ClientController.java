package au.com.vodafone.clientservice.controller;

import au.com.vodafone.clientservice.model.ClientRequest;
import au.com.vodafone.clientservice.model.ClientResponse;
import au.com.vodafone.clientservice.service.ClientRepository;
import au.com.vodafone.clientservice.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;

@RequestMapping("/client")
@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(
            @NotNull final ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    @ApiResponse(responseCode = "201", description = "Save client information",
            content = @Content(mediaType = "application/json"))
    @ResponseStatus(value = HttpStatus.CREATED)
    public String addUser(ClientRequest client){
        return clientService.addUser(client);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Get client information by client id",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientRequest.class)))
    @ResponseStatus(value = HttpStatus.OK)
    public ClientResponse getClient(@NotNull Long id){
        return clientService.getClient(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteClient(@NotNull Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public String updateClient(@NotNull ClientRequest client){
        return  clientService.updateClient(client);
    }
}
