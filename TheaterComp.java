package com.example.masterclass;

import java.util.*;

public class TheaterComp {

    private final String theaterName;
    private List<Seat> seats = new ArrayList<>() {};
    private int numRows;
    private int seatsPerRow;
    private int lastRow;


    //for testing purposes
    public void sortPrice() {
        Collections.sort(seats, PRICE_ORDER);
    }

    //Setting up Comparator as an anonymous inner class (see section 10)
    //doesn't have to be static, but not having to have a class instance in order to use it is handy
    //in retrospect, we could have created Seat as a separate class, and included the Comparator in it as a Static final anonymous inner class

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            System.out.print(".");
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                if(seat1.getSeatNumber().compareTo(seat2.getSeatNumber()) < 0) { //testing on a seatNumber level now, for seats with same price
                    return -1;                      //because the sort routine is guaranteed to be stable: objects will only be swapped if specified
                } else if (seat1.getSeatNumber().compareTo(seat2.getSeatNumber()) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    };

    //we can also use a static initialiser block, as per IntelliJ's suggestion

    /*
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }*/

    public TheaterComp(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.lastRow = 'A' + (numRows - 1);

        if((numRows < 4) || (seatsPerRow < 4)) {
            System.out.println("Please ensure theater has at least four rows, and four seats per row");
            return;
        }

        for (char row = 'A'; row <= lastRow;  row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                if(seatNum==13) {
                    seatNum++;
                    seatsPerRow++;
                }

                double price = calculatePrice(row, seatNum);

                addSeat(row, seatNum, price);
            }
        }
    }

    public boolean addSeat(char row, int seatNum, double price) {
        if((row<'A')||(seatNum<0)||(price<0)) {
            System.out.println("invalid value(s)");
            return false;
        }
        Seat seat = new Seat(row + String.format("%02d", seatNum), price);
        seats.add(seat);
        return true;
    }

    private double calculatePrice(char row, int seatNum) {
        double price = 12.00;
        int premiumRow = 'A' + (numRows / 4);
        int discountRow = lastRow - (numRows / 4);
        int premiumSeat = seatsPerRow / 4;
        int discountSeat = seatsPerRow - premiumSeat;


        /*if(seatsPerRow >12) {
            discountSeat--;
        }
*/
        if(seatsPerRow % 4 != 0) {
            premiumSeat++;
        } else {
            discountSeat++;
        }

        if ((row <= premiumRow) && (seatNum > premiumSeat) && (seatNum < discountSeat)) {
            price = 14.00;
        } else if ((row > discountRow) && ((seatNum <= premiumSeat) || (seatNum >= discountSeat))) {
            price = 7.00;
        }
        return price;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public boolean reserveSeat(String seatNumber) {

        char row = seatNumber.charAt(0);
        int seatNum = Integer.parseInt(seatNumber.substring(1));

        double price = calculatePrice(row, seatNum);
        Seat requestedSeat = new Seat(seatNumber, price);
        int foundSeat = Collections.binarySearch(seats, requestedSeat,null);
        if(foundSeat >=0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public void myToString() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + " ($" + seat.getPrice() + ")");
        }
    }

    //===============================================================================
    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
            /*
            About the compareTo method that we need to implement when using the Comparable interface

            returns an int
                >0 if this.object sorts greater than the object that is being compared to
                <0 if less than...
                =0 if equal

            when implementing compareTo for a class that has more than one key field, such as firstName and lastName
                we would sort first on lastName
                    then if lastNames are equal, instead of returning 0, we would sort firstNames
             */
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved. Price is $" + price);
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " already reserved");
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}