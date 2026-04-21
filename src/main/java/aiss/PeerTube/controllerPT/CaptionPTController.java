package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.modelPT.caption.CaptionPT;
import aiss.PeerTube.repositoryPT.CaptionPTRepository;

@RestController
@RequestMapping("PeerTube/captions")
public class CaptionPTController {

    private CaptionPTRepository captionPTRepository;

    @Autowired
    public CaptionPTController (CaptionPTRepository captionPTRepository) {
        this.captionPTRepository = captionPTRepository;
    }

    // GET http://localhost:8080/PeerTube/captions
    @GetMapping
    public List<CaptionPT> getCaptions() {
        return captionPTRepository.findAll();
    }
}
