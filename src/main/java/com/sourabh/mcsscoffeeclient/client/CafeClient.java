package com.sourabh.mcsscoffeeclient.client;

import com.sourabh.mcsscoffeeclient.model.CoffeeDTO;
import com.sourabh.mcsscoffeeclient.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "coffee.shop", ignoreUnknownFields = false)
public class CafeClient {

    public final String COFFEE_PATH_V1 = "/api/v1/coffee/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    private String apiHost;

    CafeClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CoffeeDTO getCoffeeById(UUID uuid){
        return restTemplate.getForObject(apiHost + COFFEE_PATH_V1 + uuid.toString(), CoffeeDTO.class);
    }

    public URI saveNewCoffee(CoffeeDTO coffeeDTO){
        return restTemplate.postForLocation(this.apiHost + COFFEE_PATH_V1, coffeeDTO );
    }

    public void updateCoffee(UUID uuid, CoffeeDTO coffeeDTO){
        restTemplate.put(this.apiHost + COFFEE_PATH_V1 + uuid.toString(), coffeeDTO);
    }

    public void deleteCoffee(UUID uuid){
        restTemplate.delete(this.apiHost + COFFEE_PATH_V1 + uuid);
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apiHost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return  restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
    }

}
