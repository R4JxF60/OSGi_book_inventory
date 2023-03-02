package tk.rajitha.osgi.book.reader;

import tk.rajitha.osgi.book.reader.internal.ReaderDataHolder;

import java.util.logging.Logger;

public class Reader {
    private static final Logger LOGGER = Logger.getLogger(Reader.class.getName());

    public void getBookCreated(String bookName, String authorName,String ISBN){
        LOGGER.info("Book Created...!");
        ReaderDataHolder.getInstance().getBookProvider().createBook(bookName, authorName, ISBN);
    }
}
