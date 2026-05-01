package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.ChannelNotFoundException;
import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.repositoryPT.ChannelPTRepository;

@RestController
@RequestMapping("PeerTubeMiner/channels")
public class ChannelPTController {
    private ChannelPTRepository channelRepository;

    public ChannelPTController(ChannelPTRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    // GET http://localhost:8082/PeerTubeMiner/channels
    @GetMapping
    public List<ChannelPT> getChannels() {
        return channelRepository.findAllChannels();
    }
    // GET http://localhost:8082/PeerTubeMiner/channels/{channelHandle}
    @GetMapping("/{channelHandle}")
    public ChannelPT getChannelById(@PathVariable String channelHandle) throws ChannelNotFoundException{
        ChannelPT channel = channelRepository.findChannelById(channelHandle);
        if (channel == null){
            throw new ChannelNotFoundException();
        }return channel;
    }
}
