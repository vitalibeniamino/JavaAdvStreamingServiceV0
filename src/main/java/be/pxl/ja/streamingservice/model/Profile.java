package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        if (dateOfBirth.getDayOfYear() <= LocalDate.now().getDayOfYear()) age++;
        return age;
    }

    public boolean allowedToWatch(Content content) {
        if (content.getMaturityRating().getMinimumAge() <= getAge()) return true;
        return false;
    }
}
