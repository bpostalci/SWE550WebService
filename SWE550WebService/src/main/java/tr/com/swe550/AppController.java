package tr.com.swe550;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AppController {
    public static final AtomicLong firstEndpointCounter = new AtomicLong(0);
    public static final AtomicLong secondEndpointCounter = new AtomicLong(0);
    public static final AtomicLong thirdEndpointCounter = new AtomicLong(0);

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {

        System.out.println("---- /first ----");
        System.out.println("first endpoint count:" + firstEndpointCounter.incrementAndGet());
        System.out.println("---- /first ----");
        System.out.println();

        return "<p>- first endpoint is called with count=%s".formatted(firstEndpointCounter.get()) + "</p>";
    }

    @RequestMapping(value = "/second", method = RequestMethod.POST)
    public String second(@RequestBody String body) {

        System.out.println("---- /second ----");
        System.out.println("body: " + body);
        System.out.println("second endpoint count:" + secondEndpointCounter.incrementAndGet());
        System.out.println("---- /second ----");
        System.out.println();

        return "<p>- second endpoint is called with body=%s, count=%s".formatted(body, secondEndpointCounter.get()) + "</p>";
    }

    @RequestMapping(value = "/third", method = RequestMethod.GET)
    public String third(@RequestParam String param) {

        System.out.println("---- /third ----");
        System.out.println("param: " + param);
        System.out.println("third endpoint count:" + thirdEndpointCounter.incrementAndGet());
        System.out.println("---- /third ----");
        System.out.println();

        return "<p>- third endpoint is called with param=%s, count=%s".formatted(param, thirdEndpointCounter.get()) + "</p>";
    }

    @RequestMapping(value = "/broken_endpoint", method = RequestMethod.GET)
    public ResponseEntity<?> brokenEndpoint() {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
