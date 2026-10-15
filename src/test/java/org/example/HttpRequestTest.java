package org.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void postAddressBooksShouldCreateBook() {
        // Create an AddressBook; check if it's created
        restTestClient.post()
                .uri("http://localhost:%d/addressBooks".formatted(port))
                .contentType(MediaType.APPLICATION_JSON)
                .body("{}")
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    void postBuddyInfoesShouldCreateBuddy() {
        restTestClient.post()
                .uri("http://localhost:%d/buddyInfoes".formatted(port))
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"name\": \"Homer\", \"phoneNumber\": \"1234512345\"}")
                .exchange()
                .expectStatus().isCreated();
    }
}
