package aiss.PeerTube.controllerPT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // GET http://localhost:8082/peertube/{channelHandle}
    @GetMapping("/{channelHandle}")
    public ChannelVM getChannelById(@PathVariable String channelHandle) throws ChannelNotFoundException{
        ChannelVM channel = oficialRepository.getAChannel(channelHandle);
        if (channel == null){
            throw new ChannelNotFoundException();
        }
        return channel;
    }

    @PostMapping("/{channelHandle}")
    public ChannelVM createChannel(@PathVariable String channelHandle) throws ChannelNotFoundException, ChannelAlreadyExistsException {
        ChannelVM created = oficialRepository.createAChannel(channelHandle);
        if (created == null) {
            throw new ChannelNotFoundException();
        }
    return created;
}

    
}

