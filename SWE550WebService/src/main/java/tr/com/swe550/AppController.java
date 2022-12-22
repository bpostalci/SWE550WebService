package tr.com.swe550;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AppController {
    public static final AtomicLong firstEndpointCounter = new AtomicLong(0);
    public static final AtomicLong secondEndpointCounter = new AtomicLong(0);
    public static final AtomicLong thirdEndpointCounter = new AtomicLong(0);

    @GetMapping("/first")
    public String first() {
        System.out.println("first endpoint count:" + firstEndpointCounter.incrementAndGet());
        return "first endpoint";
    }

    @GetMapping("/second")
    public String second() {
        System.out.println("second endpoint count:" + secondEndpointCounter.incrementAndGet());
        return "second endpoint";
    }

    @GetMapping("/third")
    public String third() {
        System.out.println("third endpoint count:" + thirdEndpointCounter.incrementAndGet());
        return "third endpoint";
    }

}
