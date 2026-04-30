package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.VideoNotFoundException;
import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.repositoryPT.VideoPTRepository;

@RestController
@RequestMapping("PeerTubeMiner/videos")
public class VideoPTController {

    private VideoPTRepository videoRepository;

    public VideoPTController(VideoPTRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    // GET http://localhost:8082/PeerTubeMiner/videos
    @GetMapping
    public List<VideoPT> getVideos() {
        return videoRepository.findAllVideos();
    }
    // GET http://localhost:8082/PeerTubeMiner/videos/{idVideo}
    @GetMapping("/{idVideo}")
    public VideoPT getVideoById(@PathVariable String idVideo) throws VideoNotFoundException {
        return videoRepository.findVideoById(idVideo);
    }
}
