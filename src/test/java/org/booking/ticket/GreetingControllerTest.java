package org.booking.ticket;

import org.booking.ticket.controller.CityController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class GreetingControllerTest {

    private WebTestClient testClient;

    @BeforeAll
    void setUp() throws Exception {
        this.testClient = WebTestClient.bindToController(new CityController())
            .build();
    }

    @Test
    void greeting() throws Exception {
        this.testClient.get().uri("/booking") //
            .exchange() //
            .expectStatus().isOk() //
            .expectBody(String.class).isEqualTo("{\"id\":1,\"content\":\"Hello, World!\"}");
    }
}
