package cloud.delaye;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@QuarkusMain  
public class Main {

    // Logger
    public static Logger LOG = LoggerFactory.getLogger(FruitResource.class);

    public static void main(String ... args) {
        LOG.debug("Starting application");
        Quarkus.run(args); 
    }
}