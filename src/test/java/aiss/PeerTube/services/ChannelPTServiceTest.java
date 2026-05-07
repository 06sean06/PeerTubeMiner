package aiss.PeerTube.services;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelPT.video.VideoPT;

@SpringBootTest
public class ChannelPTServiceTest {
    
    @Autowired
    ChannelPTService channelPTService;



    @Test
    @DisplayName("Get videos of a channel")
    void testGetVideosOfAChannel() {
        List<VideoPT> videos = channelPTService.getVideosOfAChannel("blender_open_movies@video.blender.org", 3);
        assertFalse(videos.isEmpty(), "The list of videos should not be empty");
        assertFalse(videos.size() > 3, "The list of videos should not contain more than 3 videos");
        assertNotNull(videos.get(0).getName(), "The name of the first video should not be null");
        assertNotNull(videos.get(0).getId(), "The id of the first video should not be null");
        assertNotNull(videos.get(0).getUrl(), "The url of the first video should not be null");
    }

    @Test
    @DisplayName("Get all channels")
    void testFindAllChannels() {
        List<ChannelPT> channels = channelPTService.findAllChannels();
        assertNotNull(channels, "La lista de canales no debería ser nula");
        assertFalse(channels.isEmpty(), "The list of channels should not be empty");
        ChannelPT first = channels.get(0);
        assertNotNull(first.getName(), "El nombre del canal no debería ser nulo");
        assertNotNull(first.getDisplayName(), "El nombre público del canal no debería ser nulo");
        assertNotNull(first.getUrl(), "La URL del canal no debería ser nula");
        assertTrue(first.getUrl().contains("http"), "La URL debe ser un enlace válido");
    }

    @Test
    @DisplayName("Get a channel by name (radio@skeptikon.fr)")
    void testFindChannelById() {
        ChannelPT channel = channelPTService.findChannelById("radio@skeptikon.fr");
        assertNotNull(channel, "The channel should not be null");
        assertEquals("radio", channel.getName(), "El nombre técnico no coincide");
        assertNotNull(channel.getOwnerAccount(), "El canal debe tener una cuenta asociada");
        assertNotNull(channel.getOwnerAccount().getName(), "La cuenta debe tener un nombre de usuario");
    }
}
