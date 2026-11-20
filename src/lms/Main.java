package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Student;
import lms.model.Staff;
import lms.model.Magazine;
import lms.model.Member;
import lms.service.Library;
import lms.model.LibraryItem;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book(
                "B001",
                "Clean Code",
                "Robert C. Martin"
        );

        Book book2 = new Book(
                "B002",
                "Effective Java",
                "Joshua Bloch"
        );

        DVD dvd1 = new DVD(
                "D001",
                "Introduction to Algorithms",
                120
        );
        Magazine magazine = new Magazine(
                "M001",
                "Software Weekly",
                15
        );

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);
        library.addItem(magazine);



        Student student = new Student(
                "M001",
                "Nadeesha Perera"
        );

        Staff staff = new Staff(
                "M002",
                "Mr. Kasun Silva"
        );

        library.addMember(student);
        library.addMember(staff);

        library.listItems();

        library.listMembers();

        library.printAllLateFees(3);

        System.out.println("\n--- Loans ---");
        library.lend(book1, student);
        library.lend(book1, staff);
        library.lend(dvd1, staff);
        library.lend(magazine, staff);

        System.out.println("\n--- Reservations ---");
        library.reserveIfPossible(book1, staff);
        library.reserveIfPossible(dvd1, staff);

        System.out.println("\n--- Members ranked by activity ---");
        library.printMembersByActivity();


        try {
            Book invalidBook = new Book(
                    "B003",
                    "",
                    "Nobody"
            );
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Rejected invalid book: " + e.getMessage()
            );
        }

        library.streamIfPossible(dvd1);
    }
}