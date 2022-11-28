import java.util.ArrayList;
import java.util.Scanner;

public class Biography {

    public static void main(String[] args) {

        /**
         * WORK ON BOOK AND AUTHOR CLASSES FIRST
        This will be our actual program that we define author and his books
        In this program we will write the biography of Stefan Zweig, an Austrian novelist.


         Write a program that will get information from user and
         -Print information for the favorite author
         -Print information of the books of favorite author

        Full name = Stefan Zweig
        County = Austria
        Is still alive: No (28 November 1881 – 22 February 1942)
        Some of his books as listed below:

        BookName                            Genre           TotalPage
        Amok                                tale            189
        The Royal Game                      novella         53
        24 Hours in the Life of a Woman     novella         80
         */

        /*
        Expected result:
        Author's information = Author{firstName='Stefan', lastName='Zweig', country='Austria', isAlive=false}
        Author's books are as listed below:
        Book{name='Amok', genre:'tale', page=189}
        Book{name='The Royal Game', tale='novella', page=53}
        Book{name='24 Hours in the Life of a Woman', tale='novella', page=80}
         */

        //YOUR CODE HERE

        Scanner scanner = new Scanner(System.in);
        Author author;

        System.out.println("What is your favorite author's first name?");
        String firstName = scanner.nextLine();

        System.out.println("What is your favorite author's last name?");
        String lastName = scanner.nextLine();

        System.out.println("What country is your favorite author from?");
        String country = scanner.nextLine();

        System.out.println("Is your favorite author alive? (Y/N)");
        boolean isAlive = scanner.next().toUpperCase().startsWith("Y");

        int age = 0;

        if(isAlive){
            System.out.println("How old is he/she?");
            age = scanner.nextInt();
            scanner.nextLine();
        }


        ArrayList<Book> books = new ArrayList<>();
        String bookInfo = "";
        do{
            System.out.println("Would you like to enter book information? (Y/N)");
            bookInfo = scanner.next();
            scanner.nextLine();

            if(bookInfo.toUpperCase().startsWith("Y")){
                System.out.println("What is the name of the book?");
                String booksName = scanner.nextLine();

                System.out.println("What is the genre of the book?");
                String genre = scanner.nextLine();

                System.out.println("How many pages is the book?");
                int numberOfPages= scanner.nextInt();
                books.add(new Book(booksName, genre, numberOfPages));
            }


        } while (bookInfo.toUpperCase().startsWith("Y"));

        if(isAlive){
            author = new Author(firstName, lastName, country, true, age, books);
        }
        else {
            author = new Author(firstName, lastName, country, false, books);
        }

        System.out.println("Your favorite author's information : " + author);
        System.out.println("Some of his books as listed below : ");

        for (Book book : author.books) {
            System.out.println(book);
        }

    }
}
