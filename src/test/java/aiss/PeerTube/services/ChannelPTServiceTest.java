package aiss.PeerTube.services;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.channel.ChannelPT;

@SpringBootTest
public class ChannelPTServiceTest {
    
    @Autowired
    ChannelPTService channelPTService;

     @Test
    @DisplayName("Get all channels")
    void testFindAllChannels() {
        
        List<ChannelPT> channels = channelPTService.findAllChannels();
        assertFalse(channels.isEmpty(), "The list of channels should not be empty");
    }

        @Test
    @DisplayName("Get a channel by name (radio@skeptikon.fr)")
    void testFindChannelById() {
        ChannelPT channel = channelPTService.findChannelById("radio@skeptikon.fr");
        assertFalse(channel == null, "The channel should not be null");
    }

}
