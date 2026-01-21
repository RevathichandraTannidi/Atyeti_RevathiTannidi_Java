package oops.inheritance;

class Car extends Vehicle {

    @Override
    void start() {
        super.start();
        System.out.println("car started");
    }

    @Override
    void stop() {
        super.stop();
        System.out.println("car stopped");
    }

  public   void openTrunk() {
        System.out.println("car trunk opned");
    }
}
