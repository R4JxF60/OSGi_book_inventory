package tk.rajitha.osgi.book.provider.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import tk.rajitha.osgi.book.provider.BookProviderImpl;

import java.util.logging.Logger;

@Component(name = "tk.rajitha.osgi.book.provider", immediate = true)
public class BookProviderServiceComponent {

    private static final Logger LOGGER = Logger.getLogger(BookProviderServiceComponent.class.getName());

    @Activate
    protected void activate(ComponentContext ctx) {
        try {
            BundleContext bundleContext = ctx.getBundleContext();
            bundleContext.registerService(BookProviderImpl.class.getName(), BookProviderImpl.getInstance(), null);
            LOGGER.info("Book Provider Bundle Registered...!");
        }catch(Exception ex) {
            LOGGER.info("Error " + ex);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext ctx) {
        LOGGER.info("Book Provider Bundle Unregistered");
    }
}
