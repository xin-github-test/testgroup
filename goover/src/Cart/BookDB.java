package Cart;

import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

public class BookDB {
    private static  Map<String,Book> books=new HashMap<String ,Book>();
    static {
        books.put("1",new Book("1","java"));
        books.put("2",new Book("2","javajsp"));
        books.put("3",new Book("3","javajs"));
        books.put("4",new Book("4","javaweb"));
    }
    public static Collection<Book> getAll()
    {
        return books.values();
    }
    public static Book getBook(String  id)
    {
        return books.get(id);
    }


}
