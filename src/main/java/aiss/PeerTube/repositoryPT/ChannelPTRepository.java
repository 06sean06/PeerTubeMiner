package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.services.ChannelPTService;

@Repository
public class ChannelPTRepository {
    @Autowired
    ChannelPTService channelPTService;

    public List<ChannelPT> findAllChannels() {
        List<ChannelPT> channels = channelPTService.findAllChannels();
        return channels;
    }
    public ChannelPT findChannelById(String channelHandle) {
        ChannelPT channel = channelPTService.findChannelById(channelHandle);
        return channel;
    }
}
