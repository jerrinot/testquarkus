package info.jerrinot;

import com.hazelcast.core.HazelcastInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    private final HazelcastInstance hz;

    public ExampleResource(HazelcastInstance hz) {
        this.hz = hz;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}