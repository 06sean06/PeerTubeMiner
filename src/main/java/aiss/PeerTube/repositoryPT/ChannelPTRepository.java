package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.exception.ChannelNotFoundException;
import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.services.ChannelPTService;

@Repository
public class ChannelPTRepository {
    @Autowired
    ChannelPTService channelPTService;

    public List<ChannelPT> findAllChannels() {
        List<ChannelPT> channels = channelPTService.findAllChannels();
        return channels;
    }
    public ChannelPT findChannelById(String channelHandle) throws ChannelNotFoundException {
        ChannelPT channel = channelPTService.findChannelById(channelHandle);
        if (channel == null) {
            throw new ChannelNotFoundException();
        }
        return channel;
    }

    public List<VideoPT> getVideosOfAChannel(String channelHandle, Integer maxVideos) {
        return channelPTService.getVideosOfAChannel(channelHandle, maxVideos);
    }
}
