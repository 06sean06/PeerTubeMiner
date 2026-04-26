package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.modelPT.caption.CaptionPT;
import aiss.PeerTube.services.CaptionPTService;

@Repository
public class CaptionPTRepository {

    @Autowired
    CaptionPTService captionPTService;

    public List<CaptionPT> findAll(String idVideo) {
        List<CaptionPT> captions = captionPTService.findAllCaptionsOfVid(idVideo);
        return captions;
    }

    // No hay findOneById porque las captions no tiene id, no se puede coger sólo 1. 
}
