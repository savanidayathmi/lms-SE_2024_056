package lms.model;

public interface Loanable {
    void loan(Member member);

    void returnItem();
}
