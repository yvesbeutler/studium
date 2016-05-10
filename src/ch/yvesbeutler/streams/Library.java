package ch.yvesbeutler.streams;

import ch.yvesbeutler.models.library.Author;
import ch.yvesbeutler.models.library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yvesbeutler
 * This class demonstrates how Java 8 streams work with an example of an simple library including
 * books and their authors.
 */
public class Library {

    /**
     * method references
     * book -> book.getAuthor() can be replaced with book::getAuthor
     */

    public static void main(String[] args) {

        List<Book> library = new ArrayList<>();

        // create sample data
        library.add(new Book("Ulysses", new Author("James", "Joyce", 85, Author.Sex.MALE), 1040));
        library.add(new Book("Moonraker", new Author("Ian", "Fleming", 64, Author.Sex.MALE), 782));
        library.add(new Book("1984", new Author("George", "Orwell", 57, Author.Sex.MALE), 931));
        library.add(new Book("Alice in Wonderland", new Author("Lewis", "Carroll", 57, Author.Sex.MALE), 884));
        library.add(new Book("Pride and Prejudice", new Author("Jane", "Austen", 47, Author.Sex.FEMALE), 752));
        library.add(new Book("Jane Eyre", new Author("Charlotte", "Bronte", 59, Author.Sex.FEMALE), 1242));
        library.add(new Book("War & Piece", new Author("Leo", "Tolstoi", 74, Author.Sex.MALE), 1600));
        library.add(new Book("To Kill a Mockingbird", new Author("Harper", "Lee", 38, Author.Sex.FEMALE), 829));

        System.out.println("Case 01: Get the first names of all authors which are 65 years or older");
        System.out.println(library.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getAge() >= 65)
                .map(Author::getName)
                .collect(Collectors.toList()));

        System.out.println("Case 02: Get all books written by female authors ordered by the page size");
        System.out.println(library.stream()
                .filter(book -> book.getAuthor().getSex() == Author.Sex.FEMALE)
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .map(Book::getTitle)
                .collect(Collectors.toList()));

        System.out.println("Case 03: Get the uppercase names from 3 authors with more than 850 pages");
        System.out.println(library.stream()
                .filter(book -> book.getPages() > 850)
                .map(book -> book.getAuthor().getLastName().toUpperCase())
                .limit(3)
                .collect(Collectors.toList()));

    }

}
