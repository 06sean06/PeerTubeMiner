package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.VideoNotFoundException;
import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.model.modelVM.CaptionVM;
import aiss.PeerTube.repositoryPT.CaptionPTRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("PeerTubeMiner/captions")
public class CaptionPTController {

    private CaptionPTRepository captionPTRepository;

    //private VideoPTRepository videoPTRepository;

    @Autowired
    public CaptionPTController (CaptionPTRepository captionPTRepository) {
        this.captionPTRepository = captionPTRepository;
    }

    // GET http://localhost:8082/PeerTubeMiner/captions/{id}
    @GetMapping("/{idVideo}")
    public List<CaptionPT> getCaptions(@PathVariable String idVideo) throws VideoNotFoundException {
        List<CaptionPT> captions = captionPTRepository.findAll(idVideo); //no pido un subtítulo individual, sino una lista de subtítulos asociados a un vídeo.
    if (captions == null) {
        throw new VideoNotFoundException();
    }
    
    return captions;
}
    

    // POST http://localhost:8082/PeerTubeMiner/captions
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CaptionVM create(@RequestBody @Valid CaptionPT captionPT) {
        return captionPTRepository.createCaption(captionPT);
    }
}
