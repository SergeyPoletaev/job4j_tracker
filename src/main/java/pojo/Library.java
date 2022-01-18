package pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Murzilka", 123);
        Book book2 = new Book("Clean code", 454);
        Book book3 = new Book("Kolobok", 11);
        Book book4 = new Book("Buratino", 562);
        Book[] books = {book1, book2, book3, book4};
        System.out.println("Register of books in the library:");
        print(books);
        swap(books, 0, 3);
        System.out.println("Register of books in the library after rearrangement:");
        print(books);
        System.out.println("List of books named \"Clean Code\":");
        int count = 1;
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(count + ". " + book.getName() + " - " + book.getNumberOfPages() + " pages");
                count++;
            }
        }
    }

    private static void swap(Book[] books, int source, int dest) {
        Book tmp = books[source];
        books[source] = books[dest];
        books[dest] = tmp;
    }

    private static void print(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + 1 + ". " + books[i].getName() + " - " + books[i].getNumberOfPages() + " pages");
        }
    }
}
