package lms.model;

public interface Reservable {
    void reserve(Member member);

    void cancelReservation();

    boolean isReserved();
}
