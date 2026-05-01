package aiss.PeerTube.repositoryPT;

import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelVM.ChannelVM;

@Repository
public class OficialRepository {

    // GET http://localhost:8082/PeerTubeMiner/{channelHandle} o {username} --> CHANNEL
    // En base a este url, tengo que conseguir los videos del canal con channelPTService.getVideosOfAChannel(channelHandle) --> VIDEOS
    // Posteriormente, de cada video, obtengo sus comentarios commentPTService.getCommentsByVideo(idVideo) --> COMMENTS
    // Al mismo tiempo, podemos obtener las captions: captionPTService.findAllCaptionsOfVid(idVideo) --> CAPTIONS
    // channel.getOwnerAccount() --> USER.
    public ChannelVM getAChannel(String username) {
        return null;
    }

}
