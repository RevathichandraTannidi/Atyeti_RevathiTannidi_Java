package inheritance.hospital_System;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Someswari", 35, "Cardiology", "Cardiologist");
        Nurse nurse = new Nurse("Nurse sowmya", 19, "Emergency", 8);
        Administrator admin = new Administrator("revathi chandra admin", 25, "Administration", "HR Manager");

        System.out.println("Doctor Information ");
        doctor.displayInfo();
        doctor.diagnosePatient();

        System.out.println("Nurse Information ");
        nurse.displayInfo();
        nurse.assistDoctor();

        System.out.println(" Administrator Information ");
        admin.displayInfo();
        admin.manageOperations();
    }
}
