package com.sourabh.mcsscoffeeclient.client;

import com.sourabh.mcsscoffeeclient.model.CoffeeDTO;
import com.sourabh.mcsscoffeeclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CafeClientTest {

    @Autowired
    CafeClient cafeClient;

    @Test
    void getCoffeeById() {
        CoffeeDTO dto = cafeClient.getCoffeeById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCoffee() {
        CoffeeDTO dto = CoffeeDTO.builder().coffeeName("Sourabh Coffee").id(UUID.randomUUID()).build();
        URI uri = cafeClient.saveNewCoffee(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCoffee() {
        CoffeeDTO dto = CoffeeDTO.builder().coffeeName("New Coffee").build();
        cafeClient.updateCoffee(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCoffee() {
        cafeClient.deleteCoffee(UUID.randomUUID());
    }

   /* @Test
    void getCustomerById() {
        CustomerDto dto = cafeClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Joe").build();
        URI uri = cafeClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Jim").build();
        cafeClient.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomer() {
        cafeClient.deleteCustomer(UUID.randomUUID());
    }*/
}