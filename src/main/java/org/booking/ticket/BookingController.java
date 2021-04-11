package org.booking.ticket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BookingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/booking")
    public Greeting greeting(@RequestParam(value = "cities") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }
}