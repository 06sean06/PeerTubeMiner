package aiss.PeerTube.repositoryPT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import aiss.PeerTube.modelPT.caption.CaptionPT;
import aiss.PeerTube.modelPT.caption.LanguagePT;

@Repository
public class CaptionPTRepository {

    private List<CaptionPT> captions = new ArrayList<>();

    public CaptionPTRepository() {
        // Subtítulos en aleman. 
        LanguagePT langDe = new LanguagePT();
        langDe.setId("de");
        langDe.setLabel("German");
        CaptionPT captionDe = new CaptionPT();
        captionDe.setLanguage(langDe);
        captionDe.setAutomaticallyGenerated(false);
        captionDe.setCaptionPath("/lazy-static/video-captions/4464142a-f9dd-4443-810e-35f697012a45-de.vtt");
        captionDe.setFileUrl("https://peertube3.cpy.re/lazy-static/video-captions/4464142a-f9dd-4443-810e-35f697012a45-de.vtt");
        captionDe.setM3u8Url(null);
        captionDe.setUpdatedAt("2021-04-09T08:40:20.723Z");
        captions.add(captionDe);

        // Subtítulos en inglés.
        LanguagePT langEn = new LanguagePT();
        langEn.setId("en");
        langEn.setLabel("English");
        CaptionPT captionEn = new CaptionPT();
        captionEn.setLanguage(langEn);
        captionEn.setAutomaticallyGenerated(false);
        captionEn.setCaptionPath("/lazy-static/video-captions/3b2c44fb-e24f-4a7e-9ac7-ae820badce62-en.vtt");
        captionEn.setFileUrl("https://peertube3.cpy.re/lazy-static/video-captions/3b2c44fb-e24f-4a7e-9ac7-ae820badce62-en.vtt");
        captionEn.setM3u8Url(null);
        captionEn.setUpdatedAt("2021-04-09T08:40:20.726Z");
        captions.add(captionEn);

        //Subtítulos en francés.
        LanguagePT langFr = new LanguagePT();
        langFr.setId("fr");
        langFr.setLabel("French");
        CaptionPT captionFr = new CaptionPT();
        captionFr.setLanguage(langFr);
        captionFr.setAutomaticallyGenerated(false);
        captionFr.setCaptionPath("/lazy-static/video-captions/3bf1a43c-4856-4ba4-a4a1-b6491dcf7604-fr.vtt");
        captionFr.setFileUrl("https://peertube3.cpy.re/lazy-static/video-captions/3bf1a43c-4856-4ba4-a4a1-b6491dcf7604-fr.vtt");
        captionFr.setM3u8Url(null);
        captionFr.setUpdatedAt("2021-04-09T08:40:20.730Z");
        captions.add(captionFr);
    }

    public List<CaptionPT> findAll() {
        return captions;
    }

    // No hay findOneById porque las captions no tiene id, no se puede coger sólo 1. 
}
