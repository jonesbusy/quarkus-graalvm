package cloud.delaye;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeerResource {

    // Logger
    public static Logger LOG = LoggerFactory.getLogger(BeerResource.class);

    private Set<Beer> beers = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public BeerResource() {
        beers.add(new Beer("Cardinal", "Swiss lagger beer"));
        beers.add(new Beer("Moritz", "Barcelona Beer"));
        beers.add(new Beer("Chimey", "Belgian Beer"));
    }

    @GET
    public Set<Beer> list() {
        LOG.debug("Retrieving list of beers");
        return beers;
    }

    @POST
    public Set<Beer> add(Beer beer) {
        beers.add(beer);
        return beers;
    }

    @DELETE
    public Set<Beer> delete(Beer beer) {
        beers.removeIf(existingBeer -> existingBeer.name.contentEquals(beer.name));
        return beers;
    }
}