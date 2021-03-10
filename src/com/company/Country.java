package com.company;

public enum Country {

    MAKEDONIA("Македония", false),
    AUSTRALIA("Австралия", true),
    RUSSIA("Россия", true),
    BANGLADESH("Бангладеш", true),
    UKRAINE("Украина", true),
    DENMARK("Дания", false),
    IRAQ("Ирак", true),
    USA("США", false),
    CANADA("Канада", false);


    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    static Country getByRuName(final String ruName) throws NoSuchCountryException {
        for (Country country : values()) {
            if (country.ruName.equals(ruName)) {
                return country;
            }
        }
        throw new NoSuchCountryException("Страны " + ruName + " не существует");
    }

    String info() {
        return "Страна " + this.name() + "(" + ruName + ")" + (isOpen ? " открыта" : " закрыта") + " для посещений";
    }

    @Override
    public String toString() {
        return this.name() + "(" + ruName + ")";
    }
}
