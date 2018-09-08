package com.example.masterclass;

import java.util.*;

public class Theater {

    private final String theaterName;
    public List<Seat> seats = new ArrayList<>() {};//making seats of type Collection allows us to use any of the Collection classes

    /*
    having a look at the Interface hierarchy of the Collections framework
        We can use any concrete class that implements an interface that, itself, implements the Collections interface
        i.e. Set, List, Queue or Deque
            HashSet, test ok, unordered
            LinkedHashSet, test ok, ordered

        We have to remain on the same level of the hierarchy, however. We can't drop down a level and still expect it to work
        The Collections framework includes a TreeSet, that implements SortedSet, one level down. But here it will show a ClassCastException
        The problem here is that TreeSet needs comparable objects, and our Seat class doesn't implement the Comparable interface
     */

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow;  row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum)); //formatting with a leading zero when necessary
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat,null); //Binary search is part of the Collections interface! :)
        if(foundSeat >=0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
       /* for(Seat seat : seats) {        //the for loop we use can be compared to a brute force method.
            System.out.print(".");      // A binary search method would perform much better
            if(seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat==null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();*/
    }

    // A binary search is much more efficient than brute force. It relies on the list being sorted however. Remember the sort() method
    public boolean actualSourceCodeForBinarySearchOMG(String seatNumber) {
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp<0) {
                low = mid + 1;
            } else if (cmp>0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
    //===============================================================================
    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
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
    }
}