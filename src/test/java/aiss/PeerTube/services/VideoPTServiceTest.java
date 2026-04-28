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
        //GET https://peertube3.cpy.re/api/v1/videos
        List<VideoPT> videos = videoPTService.findAllVideos();
        assertFalse(videos.isEmpty(), "The videos list should contain at least one video");

        VideoPT first = videos.get(0);
        assertNotNull(videos, "The videos list should not be null");
        assertNotNull(first, "First video should not be null");
        assertNotNull(first.getLanguage(), "Language object should not be null");
        assertNotNull(first.getUrl(), "Video URL should not be null");
        assertNotNull(first.getCategory(), "Category object should not be null");

        assertEquals(444381, first.getId(), "The first video ID should match the expected value");
        assertEquals("8yUbMhzraebRoyRPJbHNVX", first.getShortUUID(), "The shortUUID should match");
        assertEquals("GRISE BOUILLE TV #72 — Indiana Jones & la chute à vélo",
            first.getName(), "The video name should match");
        assertEquals("French", first.getLanguage().getLabel(), "Language label should be French");
        assertEquals("Art", first.getCategory().getLabel(), "Category label should be Art");
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
