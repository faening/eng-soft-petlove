package edu.fag.petlove.enums;

public enum PetType {
    DOG("Cachorro"),
    CAT("Gato"),
    BIRD("Pássaro"),
    FISH("Peixe"),
    SMALL_MAMMAL("Pequeno mamífero"),
    REPTILE("Réptil"),
    RODENTS("Roedor"),
    EQUINE("Equino"),
    OTHER("Outro");

    private final String displayName;

    PetType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
