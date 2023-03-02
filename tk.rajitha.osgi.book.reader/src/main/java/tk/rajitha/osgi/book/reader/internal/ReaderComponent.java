package tk.rajitha.osgi.book.reader.internal;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import tk.rajitha.osgi.book.provider.BookProvider;
import tk.rajitha.osgi.book.reader.Reader;

import java.util.logging.Logger;

@Component(name = "tk.rajitha.osgi.book.reader", immediate = true)
public class ReaderComponent {

    private static final Logger LOGGER = Logger.getLogger(ReaderComponent.class.getName());

    @Activate
    protected void activate(ComponentContext ctx) {
        LOGGER.info("Reader Component Activated...!");
        Reader reader = new Reader();
        reader.getBookCreated("Madol Duva", "Martine Wicramasinghe", "ISBN78569");
    }

    @Reference(
            name="tk.rajitha.osgi.book.provider",
            service= BookProvider.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetBookProvider"
    )
    protected void setBookProvider(BookProvider bookProvider) {

        LOGGER.info("Book Provider Is Set To Reader Bundle.");
        ReaderDataHolder.getInstance().setBookProvider(bookProvider);
    }

    protected void unsetBookProvider(BookProvider bookProvider) {

        LOGGER.info("Book Provider Is Unset From Reader Bundle.");
        ReaderDataHolder.getInstance().setBookProvider(null);
    }
    @Deactivate
    protected void deactivate(ComponentContext ctx) {
        LOGGER.info("Reader Component Deactivated...!");
    }
}
