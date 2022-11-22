package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;

    private Date checkinDate;

    private Date checkoutDate;

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkinDate, Date checkoutDate) {
        validateDates(checkinDate, checkoutDate);

        this.roomNumber = roomNumber;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;

    }

    public long duration() {
        var durationTime = checkoutDate.getTime() - checkinDate.getTime();

        return TimeUnit.DAYS.convert(durationTime, TimeUnit.MILLISECONDS);
    }

    private void validateDates(Date checkinDate, Date checkoutDate) {
        var now = new Date();

        if (checkinDate.before(now) || checkoutDate.before(now)) {
            throw new DomainException("Dates must be a future/current date");
        }

        if (checkoutDate.before(checkinDate)) {
            throw new DomainException("Checkout date is before checkin date");
        }
    }


    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    @Override
    public String toString() {
        return String.format("Room number: %s, Check-in: %s, Check-out: %s, Duration: %s nights",
                roomNumber,
                dateFormatter.format(checkinDate),
                dateFormatter.format(checkoutDate),
                duration()
        );
    }
}
