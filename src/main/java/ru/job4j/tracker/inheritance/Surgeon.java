package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private String hospital;

    public Surgeon(String name, String surname, String education, String birthday, int experience, String hospital) {
        super(name, surname, education, birthday, experience);
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public Report procedure(Pacient pacient, Diagnosis diagnosis) {
        return new Report();
    }
}
