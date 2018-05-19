package com.company;

public class Quest {

    private String name;
    private String description;

    public Quest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /* Getters */
    public String getName() { return name; }
    public String getDescription() { return description; }
    /* END */

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    /* END */
}
