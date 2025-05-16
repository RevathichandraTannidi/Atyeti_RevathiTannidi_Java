package inheritance.hospital_System;

class Doctor extends HospitalEmployee {
    String specialization;

    Doctor(String name, int age, String department, String specialization) {
        super(name, age, department);
        this.specialization = specialization;
    }

    void diagnosePatient() {
        System.out.println(name + " is diagnosing a patient.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
    }
}