package tickets;


public class BoardingPass {
    public String boardingTime;
    public String gate;
    public String seat;
    public int ticketNum;
    public String passengerName;

    private BoardingPass(Builder builder) {
        this.boardingTime = builder.boardingTime;
        this.gate = builder.gate;
        this.seat = builder.seat;
        this.ticketNum = builder.ticketNum;
        this.passengerName = builder.passengerName;
    }


    public static class Builder {
        public String boardingTime;
        public String gate;
        public String seat;
        public int ticketNum;
        public String passengerName;

        public Builder(int ticketNum) {
            this.ticketNum = ticketNum;
        }

        public Builder isFlying(String passengerName) {
            this.passengerName = passengerName;
            return this;
        }

        public Builder withBoardingTime(String boardingTime) {
            this.boardingTime = boardingTime;
            return this;
        }

        public Builder atGate(String gate) {
            this.gate = gate;
            return this;
        }

        public Builder inSeat(String seat) {
            this.seat = seat;
            return this;
        }

        public BoardingPass build() {
            return new BoardingPass(this);
        }
    }
}