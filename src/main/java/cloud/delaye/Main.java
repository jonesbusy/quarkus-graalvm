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

    @OpenAPIDefinition(
        tags = {
                @Tag(name="widget", description="Widget operations."),
                @Tag(name="gasket", description="Operations related to gaskets")
        },
        info = @Info(
            title="Example API",
            version = "1.0.1",
            contact = @Contact(
                name = "Example API Support",
                url = "http://exampleurl.com/contact",
                email = "techsupport@example.com"),
            license = @License(
                name = "Apache 2.0",
                url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
    )
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