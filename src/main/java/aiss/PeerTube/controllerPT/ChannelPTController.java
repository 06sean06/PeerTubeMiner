package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.ChannelNotFoundException;
import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelVM.ChannelVM;
import aiss.PeerTube.repositoryPT.ChannelPTRepository;
import aiss.PeerTube.repositoryPT.OficialRepository;

@RestController
@RequestMapping("PeerTubeMiner/channels")
public class ChannelPTController {
    private ChannelPTRepository channelRepository;

    @Autowired
    private OficialRepository oficialRepository;

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
    public ChannelVM getChannelById(@PathVariable String channelHandle) throws ChannelNotFoundException{
        ChannelVM channel = oficialRepository.getAChannel(channelHandle);
        if (channel == null){
            throw new ChannelNotFoundException();
        }return channel;
    }
}
