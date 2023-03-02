package tk.rajitha.osgi.book.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import tk.rajitha.osgi.book.provider.model.Book;

public class BookProviderImpl implements BookProvider {
    private static final Logger LOGGER = Logger.getLogger(BookProviderImpl.class.getName());
    private static volatile BookProviderImpl bookProvider;
    private static final List<Book> books = new ArrayList<Book>();

    private BookProviderImpl() {

    }

    public static BookProviderImpl getInstance() {
        if(bookProvider == null) {
            synchronized (BookProviderImpl.class) {
                if(bookProvider == null) {
                    bookProvider = new BookProviderImpl();
                }
            }
        }
        return bookProvider;
    }

    @Override
    public void createBook(String bookName, String authorName, String ISBN) {
        Book book = new Book(bookName, authorName, ISBN);
        books.add(book);
        LOGGER.info("Created a Book " + book.getBookName());
    }

    @Override
    public List<Book> listBooks() {
        return books;
    }
}
