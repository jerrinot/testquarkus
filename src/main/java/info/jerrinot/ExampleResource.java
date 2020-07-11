package info.jerrinot;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class ExampleResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        try {
            IMap<Long, UUID> map = hazelcastInstance.getMap("myMap");
            map.set(System.currentTimeMillis(), UUID.randomUUID());
        } finally {
            hazelcastInstance.shutdown();
        }
        return "stored";
    }
}