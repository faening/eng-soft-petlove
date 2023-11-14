package edu.fag.petlove.enums;

public enum PetSize {
    MINI("Mini"),
    SMALL("Pequeno"),
    MEDIUM("Médio"),
    BIG("Grande"),
    GIANT("Gigante");

    private final String displayName;

    PetSize(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
