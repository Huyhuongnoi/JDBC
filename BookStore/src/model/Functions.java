package model;

import dao.DaoBooks;

import java.util.List;


public class Functions {
    public static void add(String id, String bookName, float rate, int status) {
        Books books = new Books(id, bookName, rate, status);
        DaoBooks.getInstance().add(books);
    }

    public static void update(Books books) {
        DaoBooks.getInstance().update(books);
    }

    public static void delete(String id) {
        Books books = new Books();
        books.setId(id);
        DaoBooks.getInstance().delete(books);
    }

    public static void view() {
        List<Books> listbook = DaoBooks.getInstance().sellectAll();
        for (Books books : listbook) {
            if (books.getStatus() != 0) {
                System.out.println(books.toString());
            }
        }
    }

    public static Books findById(String id) {
        Books books = new Books();
        books.setId(id);
        Books book = DaoBooks.getInstance().sellectById(books);
        if (book == null) {
            System.out.println("The book does not exist!");
            return book;
        }
        System.out.println(book.toString());
        return book;
    }

    public static void find(String text) {
        List<Books> booksList = DaoBooks.getInstance().sellectByCondition(text);
        if (booksList.isEmpty()) {
            System.out.println("The book does not exist!");
            return;
        }
        for (int index = 0; index < booksList.size(); index++) {
            System.out.println(booksList.get(index).toString());
        }
    }
}
