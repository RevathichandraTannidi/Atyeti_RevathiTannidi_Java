package inheritance.hospital_System;

class Administrator extends HospitalEmployee {
    String role;

    Administrator(String name, int age, String department, String role) {
        super(name, age, department);
        this.role = role;
    }

    void manageOperations() {
        System.out.println(name + " is managing hospital operations.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: " + role);
    }
}