package aiss.PeerTube.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.video.VideoPT;

@SpringBootTest
public class VideoPTServiceTest {

    @Autowired
    VideoPTService videoPTService;

    @Test
    @DisplayName("Get all videos") 
    void testFindAllVideos() {
        List<VideoPT> videos = videoPTService.findAllVideos();
        assertFalse(videos.isEmpty(), "La lista no debería estar vacía");
        
        VideoPT first = videos.get(0);
        
        assertNotNull(first.getId(), "El ID no debe ser nulo");
        assertNotNull(first.getName(), "El nombre no debe ser nulo");
        assertNotNull(first.getShortUUID(), "El UUID no debe ser nulo");
        assertNotNull(first.getLanguage(), "El objeto lenguaje no debe ser nulo");
        assertTrue(first.getId() > 0, "El ID debería ser un número positivo");
}


    @Test
    @DisplayName("Get video by id")
    void testFindVideoById() {
        // GET https://peertube3.cpy.re/api/v1/videos/5JoZUZzbUdpNqGXpd5QJ5T
        VideoPT video = videoPTService.findVideoById("5JoZUZzbUdpNqGXpd5QJ5T");

        assertNotNull(video, "The video should not be null");
        assertNotNull(video.getDuration(), "Video duration should not be null");
        assertNotNull(video.getLanguage(), "Video language should not be null");

        assertTrue(video.getDuration() > 0, "Video duration should be greater than zero");

        assertEquals("English", video.getLanguage().getLabel(),
                "The video language should be English");
        assertEquals("5JoZUZzbUdpNqGXpd5QJ5T", video.getShortUUID(),
                "The shortUUID should match the requested video ID");
        assertEquals("Agent 327: Operation Barbershop", video.getName(),
                "The video name should match the expected title");
    }
}
