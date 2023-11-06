import java.util.PriorityQueue;

public class Q1845_SeatReservationManager {

    class SeatManager {
        PriorityQueue<Integer> availableSeats;
        int nextSeat = 1;
        Integer temp;

        public SeatManager(int n) {
            availableSeats = new PriorityQueue<Integer>();
        }

        public int reserve() {
            temp = availableSeats.peek();
            if (temp != null && temp < nextSeat) {
                return availableSeats.poll();
            } else {
                return nextSeat++;
            }

        }

        public void unreserve(int seatNumber) {
            availableSeats.add(seatNumber);
        }
    }

    /**
     * Your SeatManager object will be instantiated and called as such:
     * SeatManager obj = new SeatManager(n);
     * int param_1 = obj.reserve();
     * obj.unreserve(seatNumber);
     */
}
