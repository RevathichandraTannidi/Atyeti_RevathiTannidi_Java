package org.atyeti.locks_synchronized.ticketBookingSystem;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class TickeTCounter {
    private final ReentrantLock lock=new ReentrantLock(true);
    private final Condition ticketsAvail=lock.newCondition();
    private int availableTickets;

    public TickeTCounter(int totalTickets) {

        this.availableTickets=totalTickets;
    }

    public void bookTicket(String user) {
        try {
            lock.lockInterruptibly();
            System.out.println(user+" : is trying to booking");
            while ((availableTickets == 0))
             {
                 System.out.println(user +" : is waiting for a ticket");
                 ticketsAvail.await();

            }
            availableTickets--;
            System.out.println(user +" : successfully booked a ticket "+availableTickets);

        } catch (InterruptedException e) {
            System.out.println(user+" interrputed and gave up booking");
        }
        finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

    }
  public  void releaseTicket(String user) {

        lock.lock();
        try {
            availableTickets++;
            System.out.println(user + " : released tickets,availbilty :" + availableTickets);
            ticketsAvail.signal();
        }finally {
        lock.unlock();
        }

  }
}



