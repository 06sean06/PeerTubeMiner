package aiss.PeerTube.PTController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.PTRepository.ChannelRepository;
import aiss.PeerTube.modelPT.channel.ChannelPT;

@RestController
@RequestMapping("PeerTube/channels")
public class ChannelController {
    private ChannelRepository channelRepository;
    public ChannelController(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

@GetMapping
public List<ChannelPT> getChannels() {
    return channelRepository.findAllChannels();
}
@GetMapping("/{channelHandle}")
public ChannelPT getChannelById(@PathVariable String channelHandle) {
    return channelRepository.findChannelById(channelHandle);

}
}
