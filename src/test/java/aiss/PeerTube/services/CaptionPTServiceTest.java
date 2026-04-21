package aiss.PeerTube.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.modelPT.caption.CaptionPT;

@SpringBootTest
public class CaptionPTServiceTest {

    @Autowired
    CaptionPTService CaptionPTService;

    @Test
    @DisplayName("Get all captions from a video")
    void testFindAllCaptionsOfVid() {
        // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
        List<CaptionPT> captions = CaptionPTService.findAllCaptionsOfVid("58UdeJ7NayzNSScpTE3YRa");
        assertFalse(captions.isEmpty(), "The list of captions of vid should not be empty");
        assertNotNull(captions);

    }
}
