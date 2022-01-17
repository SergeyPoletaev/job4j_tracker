package ru.job4j.tracker.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, String company, String language) {
        super(name, surname, education, birthday, company);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
