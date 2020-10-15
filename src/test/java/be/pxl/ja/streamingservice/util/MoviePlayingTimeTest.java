package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoviePlayingTimeTest {

    private Movie movie;


    @BeforeEach
    public void init() {
        movie = new Movie("Titanic", Rating.OLDER_KIDS);
    }

    @Test
    public void movieWithDurationShorterThanLongPlayingTimeReturnsFalse() {
        movie.setDuration(Movie.LONG_PLAYING_TIME - 1);
        assertFalse(movie.isLongPlayingTime());
    }

    @Test
    public void movieWitDurationExactlyLongPlayingTimeReturnsTrue() {
        movie.setDuration(Movie.LONG_PLAYING_TIME);
        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    public void movieWitDurationLongerThanPlayingTimeReturnsTrue() {
        movie.setDuration(Movie.LONG_PLAYING_TIME + 1);
        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    public void returnsQuestionmarkWhenDurationZero() {
        movie.setDuration(0);
        assertEquals("?", movie.getPlayingTime());
    }

    @Test
    public void returnsMinutesWhenDurationLessThan60() {
        movie.setDuration(59);
        assertEquals("59min", movie.getPlayingTime());
    }

    @Test
    public void returnHoursWhenDurationMultipleOf60() {
        movie.setDuration(120);
        assertEquals("2h", movie.getPlayingTime());
    }

    @Test
    public void returnsHoursAndMinutesWhenDurationNotMultipleOf60() {
        movie.setDuration(135);
        assertEquals("2h 15min", movie.getPlayingTime());
    }
}