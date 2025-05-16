package inheritance.hospital_System;

class Nurse extends HospitalEmployee {
    int shiftHours;

    Nurse(String name, int age, String department, int shiftHours) {
        super(name, age, department);
        this.shiftHours = shiftHours;
    }

    void assistDoctor() {
        System.out.println(name + " is assisting in surgery.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Shift Hours: " + shiftHours);
    }
}
