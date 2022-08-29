package pract_lesson_.CollectionsOverviewLecture;

import java.util.*;

//imitation of the theater booking system
public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    //anonymous class, it has to return same values as compareTo method
    //this approach is inefficient, as there might be different seat numbers with the same price
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>(){
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }
            else if(seat1.getPrice() > seat2.getPrice()){
                return 1;
            }
            else
                return 0;
        }
    };

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 0; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if(row < 'D' && (seatNum >= 4 && seatNum <= 9)){
                    price = 14.00;
                }
                else if(row > 'F' || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNum){
//        Seat requestedSeat = null;
//        for(Seat seat : seats){
//            if(seat.getSeatNumber().equals(seatNum)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if(requestedSeat == null){
//            System.out.println("No such seat as " + seatNum);
//            return false;
//        }
//
//        return requestedSeat.reserve();

        Seat requestedSeat = new Seat(seatNum, 0.00);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("No such seat as " + seatNum);
            return false;
        }
    }

//    public void getSeats(){
//        for(Seat seat : seats){
//            System.out.println(seat.getSeatNumber());
//        }
//    }

    public Collection<Seat> getSeats() {
        return this.seats;
    }

    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return this.price;
        }

        //at the beginning used for ArrayList for loop, but it's inefficient in terms of search
        //thus implementing comparable interface, override compareTo method to use built String compareTo and change reserveSeat() method to use Collections.binarySearch()
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " is reserved.");
                return true;
            }
            else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of the " + seatNumber + " is canceled");
                return true;
            }
            else{
                return false;
            }
        }
    }
}
