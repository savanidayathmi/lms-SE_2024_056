
package lms.service;

import lms.model.LibraryItem;
import lms.model.Member;
import lms.model.Book;
import lms.model.DVD;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();


    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added via addItem(LibraryItem): " + item.getTitle());
    }

    public void addItem(Book book) {
        items.add(book);
        System.out.println("Added via addItem(Book): " + book.getTitle());
    }

    public void addItem(DVD dvd) {
        items.add(dvd);
        System.out.println("Added via addItem(DVD): " + dvd.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void listItems() {
        System.out.println("--- Items in the library ---");

        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        System.out.println("--- Registered members ---");

        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");

        for (LibraryItem item : items) {
            System.out.println(
                    item.getTitle() + ": " +
                            item.calculateLateFee(daysLate)
            );
        }
    }


    public void streamIfPossible(LibraryItem item) {

        if (item instanceof DVD dvd) {
            System.out.println(
                    "Streaming \"" + dvd.getTitle() +
                            "\" (" + dvd.getDurationMinutes() + " min)..."
            );
        } else {
            System.out.println(
                    item.getTitle() +
                            " cannot be streamed - it isn't a DVD."
            );
        }
    }
}
