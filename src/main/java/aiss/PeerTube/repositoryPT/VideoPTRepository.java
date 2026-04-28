package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.video.VideoPT;
import aiss.PeerTube.services.VideoPTService;

@Repository
public class VideoPTRepository {

    @Autowired
    VideoPTService videoPTService;

    public List<VideoPT> findAllVideos() {
        List<VideoPT> videos = videoPTService.findAllVideos();
        return videos;
    }
    public VideoPT findVideoById(String idVideo) {
        VideoPT video = videoPTService.findVideoById(idVideo);
        return video;
    }

}
