package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.model.modelVM.CaptionVM;
import aiss.PeerTube.services.CaptionPTService;

@Repository
public class CaptionPTRepository {

    @Autowired
    CaptionPTService captionPTService;

    // GET ALL CAPTIONS
    public List<CaptionPT> findAll(String idVideo) {
        List<CaptionPT> captions = captionPTService.findAllCaptionsOfVid(idVideo);
        return captions;
    }

    //POST A CAPTION
    public CaptionVM createCaption(CaptionPT captionPT) {
        CaptionVM caption = captionPTService.createCaption(captionPT);
        return caption;
    }
}
