package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private String ambulance;

    public Dentist(String name, String surname, String education, String birthday, int experience, String ambulance) {
        super(name, surname, education, birthday, experience);
        this.ambulance = ambulance;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public Report drillingTooth(Pacient pacient, Diagnosis diagnosis) {
        return new Report();
    }
}
