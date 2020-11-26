package cloud.delaye;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@QuarkusMain  
public class Main {

    // Logger
    public static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String ... args) {
        Quarkus.run(DemoApp.class, args); 
    }

    public static class DemoApp implements QuarkusApplication {

        // Logger
        public static Logger LOG = LoggerFactory.getLogger(Main.class);

        @Override
        public int run(String... args) throws Exception {
            LOG.debug("Starting application");
            Quarkus.waitForExit();
            return 0;
        }
    }

}