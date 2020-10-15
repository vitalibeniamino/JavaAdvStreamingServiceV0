package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentaryTest {
    private static final String TITLE = "Planet Earth";

    @Test
    public void documentaryConstructor() {
        //ACT
        Documentary documentary = new Documentary(TITLE, Rating.TEENS);

        // ASSERT
        assertEquals(TITLE, documentary.getTitle());
        assertEquals(Rating.TEENS, documentary.getMaturityRating());
        assertEquals(Genre.DOCUMENTARY, documentary.getGenre());
    }
}