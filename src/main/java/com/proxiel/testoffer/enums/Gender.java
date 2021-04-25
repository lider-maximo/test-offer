package com.proxiel.testoffer.enums;

/**
 * Gender enum
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
public enum Gender {

    M("M", "Male"),
    F("F", "Female");

    private String key;
    private String name;

    /**
     * Constructor with params
     *
     * @param key
     * @param name
     */
    private Gender(String key, String name) {
        this.key = key;
        this.name = name;
    }

    // Getters

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getKey();
    }
}
