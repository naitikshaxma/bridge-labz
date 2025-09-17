import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;       // sensitive
    private List<String> history;   // sensitive

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.history = new ArrayList<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected List<String> getHistory() {
        return history;
    }

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String id, String name, int age, int daysAdmitted, double dailyRate) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        getHistory().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String r : getHistory()) {
            System.out.println(" - " + r);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        getHistory().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String r : getHistory()) {
            System.out.println(" - " + r);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient("P101", "Alice", 30, 5, 2000);
        ip.setDiagnosis("Pneumonia");
        ip.addRecord("Admitted for pneumonia treatment");
        ip.addRecord("Completed antibiotic course");

        OutPatient op = new OutPatient("P202", "Bob", 25, 500);
        op.setDiagnosis("Allergic Rhinitis");
        op.addRecord("Consultation for seasonal allergies");

        patients.add(ip);
        patients.add(op);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Diagnosis: " + p.getDiagnosis());
            System.out.println("Bill Amount: " + p.calculateBill());

            if (p instanceof MedicalRecord m) {
                m.viewRecords();
            }
            System.out.println("----------------------------------");
        }
    }
}
