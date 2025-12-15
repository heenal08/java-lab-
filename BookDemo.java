import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int num_pages;

    // Constructor
    Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Setter methods
    void setName(String name) {
        this.name = name;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    // Getter methods
    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    double getPrice() {
        return price;
    }

    int getNumPages() {
        return num_pages;
    }

    // toString() method
    public String toString() {
        return "Book Name: " + name +
               "\nAuthor: " + author +
               "\nPrice: " + price +
               "\nNumber of Pages: " + num_pages;
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Book " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of pages: ");
            int pages = sc.nextInt();
            sc.nextLine(); // consume newline

            books[i] = new Book(name, author, price, pages);
        }

        System.out.println("\n----- Book Details -----");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1));
            System.out.println(books[i]); // calls toString()
        }

        sc.close();
    }
}
