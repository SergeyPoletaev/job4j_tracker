package ru.job4j.tracker.inheritance;

public class Builder extends Engineer {
    private boolean tools;

    public Builder(String name, String surname, String education, String birthday, String company, boolean tools) {
        super(name, surname, education, birthday, company);
        this.tools = tools;
    }

    public boolean getTools() {
        return tools;
    }
}
