package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.VideoNotFoundException;
import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.model.modelVM.VideoVM;
import aiss.PeerTube.repositoryPT.VideoPTRepository;
import jakarta.validation.Valid;

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

     // POST http://localhost:8082/PeerTubeMiner/videos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideoVM create(@RequestBody @Valid VideoPT videoPT) {
        return videoRepository.createVideo(videoPT);
    }
}
