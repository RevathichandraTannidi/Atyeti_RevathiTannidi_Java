package org.atyeti.locks_synchronized.ticketBookingSystem;

public class TicketBooking {
    public static void main(String[] args) {
        TickeTCounter count = new TickeTCounter(3);
        for (int i = 1; i < 7; i++) {
            final String SUser = "user -" + i;
            Thread t = new Thread(() -> {
                count.bookTicket(SUser);
            });
            t.start();
            if (i == 4 || i == 5) {
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(SUser + " sorry,inteerputed error");
                        t.interrupt();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }

        new Thread(() -> {
            try {
                Thread.sleep(4000);
                count.releaseTicket("rc ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

}

