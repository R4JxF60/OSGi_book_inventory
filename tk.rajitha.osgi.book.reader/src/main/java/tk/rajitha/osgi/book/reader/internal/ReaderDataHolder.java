package tk.rajitha.osgi.book.reader.internal;

import tk.rajitha.osgi.book.provider.BookProvider;

import java.util.logging.Logger;

public class ReaderDataHolder {
    private static final Logger LOGGER = Logger.getLogger(ReaderDataHolder.class.getName());
    private static ReaderDataHolder holder = new ReaderDataHolder();
    private BookProvider bookProvider;

    private ReaderDataHolder() {

    }

    public static ReaderDataHolder getInstance() {
        return holder;
    }

    public void setBookProvider(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public BookProvider getBookProvider() {
        return bookProvider;
    }
}
