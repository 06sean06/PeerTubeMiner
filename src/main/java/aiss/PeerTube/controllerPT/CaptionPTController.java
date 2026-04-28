package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.VideoNotFoundException;
import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.repositoryPT.CaptionPTRepository;

@RestController
@RequestMapping("PeerTube/captions")
public class CaptionPTController {

    private CaptionPTRepository captionPTRepository;

    //private VideoPTRepository videoPTRepository;

    @Autowired
    public CaptionPTController (CaptionPTRepository captionPTRepository) {
        this.captionPTRepository = captionPTRepository;
    }

    // GET http://localhost:8080/PeerTube/captions/{id}
    @GetMapping("/{idVideo}")
    public List<CaptionPT> getCaptions(@PathVariable String idVideo) throws VideoNotFoundException {
        return captionPTRepository.findAll(idVideo);
    }
}
