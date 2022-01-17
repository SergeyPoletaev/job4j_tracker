package ru.job4j.tracker.inheritance;

public class Doctor extends Profession {
    private int experience;

    public Doctor(String name, String surname, String education, String birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    public Diagnosis survey(Pacient pacient) {
        return new Diagnosis();
    }

    public int getExperience() {
        return experience;
    }
}
