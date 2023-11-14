package edu.fag.petlove.enums;

public enum SpecificationName {
    PET("Pet"),
    AGE("Idade"),
    SIZE("Porte"),
    SPECIE("Raça"),
    TYPE("Tipo"),
    FLAVOR("Sabor"),
    PRESENTATION("Apresentação"),
    COMPOSITION("Composição");

    private final String displayName;

    SpecificationName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
