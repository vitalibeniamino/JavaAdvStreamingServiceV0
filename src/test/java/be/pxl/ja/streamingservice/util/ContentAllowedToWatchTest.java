package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.model.Rating;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ContentAllowedToWatchTest {
    @Test
    public void SubIsOlderThan18YearsAndCanWatchEverything() {
        Profile profile = new Profile();
        profile.setName("test");
        profile.setDateOfBirth(LocalDate.of(2000,9,6));

        Movie movie = new Movie("test", Rating.MATURE);

        assertTrue(profile.allowedToWatch(movie));
    }
}
