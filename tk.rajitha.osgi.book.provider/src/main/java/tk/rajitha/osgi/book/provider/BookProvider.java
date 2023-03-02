package tk.rajitha.osgi.book.provider;

import tk.rajitha.osgi.book.provider.model.Book;
import java.util.List;

public interface BookProvider {
    void createBook(String bookName, String authorName, String ISBN);

    List<Book> listBooks();
}
