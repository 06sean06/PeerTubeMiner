package aiss.PeerTube.controllerPT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.ChannelAlreadyExistsException;
import aiss.PeerTube.exception.ChannelNotFoundException;
import aiss.PeerTube.model.modelVM.ChannelVM;
import aiss.PeerTube.repositoryPT.OficialRepository;


@RestController
@RequestMapping("peertube")
public class OficialController {

    private OficialRepository oficialRepository;

    public OficialController(OficialRepository oficialRepository) {
        this.oficialRepository = oficialRepository;
    }

// GET http://localhost:8082/PeerTubeMiner/channels/{channelHandle}?maxVideos=3&maxPages=2
    @GetMapping("/{channelHandle}")
    public ChannelVM getChannelById(
            @PathVariable String channelHandle,
            @RequestParam(required = false) Integer maxVideos,
            @RequestParam(required = false) Integer maxPages
    ) throws ChannelNotFoundException {
        ChannelVM channel;

    
        if (maxVideos != null || maxPages != null) {
            channel = oficialRepository.getAChannel(channelHandle,maxVideos , maxPages);
        } else {
            channel = oficialRepository.getAChannel(channelHandle);
        }

        if (channel == null) {
            throw new ChannelNotFoundException();
        }
        
        return channel;
    }

    @PostMapping("/{channelHandle}")
    public ChannelVM createChannel(@PathVariable String channelHandle,@RequestParam(required = false) Integer maxVideos,
    @RequestParam(required = false) Integer maxPages) throws ChannelNotFoundException, ChannelAlreadyExistsException {
        ChannelVM channel;
         if (maxVideos != null || maxPages != null) {
            channel = oficialRepository.createAChannel(channelHandle,maxVideos , maxPages);
        } else {
            channel = oficialRepository.createAChannel(channelHandle);
        }
        if (channel == null) {
            throw new ChannelNotFoundException();
        }
    return channel;
}

    
}

