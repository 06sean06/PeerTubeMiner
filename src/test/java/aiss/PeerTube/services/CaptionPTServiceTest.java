package aiss.PeerTube.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.model.modelVM.CaptionVM;

@SpringBootTest
public class CaptionPTServiceTest {

    @Autowired
    CaptionPTService CaptionPTService;

    @Test
    @DisplayName("Get all captions from a video")
    void testFindAllCaptionsOfVid() {
        // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
        List<CaptionPT> captions = CaptionPTService.findAllCaptionsOfVid("58UdeJ7NayzNSScpTE3YRa");
        assertFalse(captions.isEmpty(), "The captions list should contain at least one caption");
        assertNotNull(captions, "The captions list should not be null");
        CaptionPT first = captions.get(0);
        assertNotNull(first, "First caption should not be null");
        assertNotNull(first.getLanguage(), "Caption language should not be null");
        assertNotNull(first.getFileUrl(), "Caption file URL should not be null");
        assertNotNull(first.getUpdatedAt(), "Caption updatedAt should not be null");
        assertNotNull(first.getAutomaticallyGenerated(), "Caption automaticallyGenerated should not be null");
        assertNotNull(first.getLanguage().getId(), "Caption language ID should not be null");
        assertNotNull(first.getLanguage().getLabel(), "Caption language name should not be null");
        assertTrue(first.getCaptionPath().endsWith(".vtt") || first.getCaptionPath().endsWith(".srt"), "Caption path should end with .vtt or .srt");
        assertTrue(captions.stream().allMatch(c -> c.getCaptionPath() != null), "Todos los subtítulos de la lista deben tener un path definido");
    }

    @Test
    @DisplayName("Create caption")
    void testCreateCaption() {
        List<CaptionPT> captions = CaptionPTService.findAllCaptionsOfVid("58UdeJ7NayzNSScpTE3YRa");
        assertFalse(captions.isEmpty(), "The captions list should contain at least one caption");
        CaptionPT first = captions.get(0);
        assertNotNull(first, "First caption should not be null");
        CaptionVM createdCaption = CaptionPTService.createCaption(first);
        assertNotNull(createdCaption, "Created caption should not be null");
        assertNotNull(createdCaption.getLanguage(), "Created caption language should not be null");
        assertNotNull(createdCaption.getLink(), "Created caption link should not be null");
        assertTrue(createdCaption.getLink().endsWith(".vtt") || createdCaption.getLink().endsWith(".srt"), "Created caption link should end with .vtt or .srt");
    }
}
