package au.com.vodafone.clientservice.service;

import au.com.vodafone.clientservice.model.ClientRequest;
import au.com.vodafone.clientservice.model.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
public class ClientService {

    public static final String CLIENT_CACHE_REGION = "CLIENT_CACHE";

    private final ClientRepository clientRepository;

    public ClientService(
            @NotNull final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String addUser(@NotNull ClientRequest client){
        clientRepository.save(client);
        return "Success";
    }

    @Cacheable(cacheNames = CLIENT_CACHE_REGION, key = "#id.valueZeroPadded")
    public ClientResponse getClient(@NotNull final Long id){
        return retrieveClientById(id);
    }

    @CachePut(cacheNames = CLIENT_CACHE_REGION, key = "#id.valueZeroPadded")
    public ClientResponse retrieveClientById(@NotNull final Long id){
        return clientRepository.get(id);
    }

    @CacheEvict(cacheNames = CLIENT_CACHE_REGION, key = "#id.valueZeroPadded")
    public void deleteClient(@NotNull final Long id){
        clientRepository.deleteById(id);
        log.debug("clearing cache for client {}", id);
    }

    public String updateClient(@NotNull final ClientRequest client){
        clientRepository.save(client);
        return "OK";
    }
}
