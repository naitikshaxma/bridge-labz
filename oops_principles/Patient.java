import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void showDoctors() {
        System.out.println("Doctors consulted by " + name + ":");
        if (doctors.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Doctor d : doctors) {
                System.out.println("  " + d.getName() + " (" + d.getSpecialization() + ")");
            }
        }
        System.out.println();
    }
}

class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void consult(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        }
        p.addDoctor(this);
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting " + p.getName());
    }

    public void showPatients() {
        System.out.println("Patients of Dr. " + name + ":");
        if (patients.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Patient p : patients) {
                System.out.println("  " + p.getName());
            }
        }
        System.out.println();
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void showDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  " + d.getName() + " (" + d.getSpecialization() + ")");
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("  " + p.getName());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital h = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor("Alice", "Cardiologist");
        Doctor d2 = new Doctor("Bob", "Dermatologist");

        Patient p1 = new Patient("Charlie");
        Patient p2 = new Patient("Diana");

        h.addDoctor(d1);
        h.addDoctor(d2);
        h.addPatient(p1);
        h.addPatient(p2);

        h.showDetails();

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println();
        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();
    }
}
