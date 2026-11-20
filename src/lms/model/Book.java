package lms.model;

public class Book extends LibraryItem implements Reservable{

    private String author;
    private Member reservedBy;

    public Book(String id, String title, String author) {
        super(id, title);
        setAuthor(author);
        this.reservedBy = null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }

        this.author = author;
    }
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    @Override
    public void reserve(Member member) {

        if (reservedBy == null) {
            reservedBy = member;

            System.out.println(getTitle() + " reserved for " + member.getName());
        } else {
            System.out.println(getTitle() + " is already reserved.");
        }
    }

    @Override
    public void cancelReservation() {
        reservedBy = null;
    }

    @Override
    public boolean isReserved() {
        return reservedBy != null;
    }
}