package edu.fag.petlove.enums;

public enum PetAge {
    PUP("Filhote"),
    ADULT("Adulto"),
    OLD("Velho");

    private final String displayName;

    PetAge(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
