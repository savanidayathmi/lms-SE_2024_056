package lms.model;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }
}