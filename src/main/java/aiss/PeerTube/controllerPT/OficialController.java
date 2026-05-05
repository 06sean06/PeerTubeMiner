package aiss.PeerTube.controllerPT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // GET http://localhost:8082/peertube/{name}
    @GetMapping("/{name}")
    public ChannelVM getChannelByName(@PathVariable String name) throws ChannelNotFoundException{
        ChannelVM channel = oficialRepository.getAChannelByName(name);
        if (channel == null){
            throw new ChannelNotFoundException();
        }
        return channel;
    }

    @PostMapping("/{name}")
    public ChannelVM createChannel(@PathVariable String name) throws ChannelNotFoundException {
        ChannelVM created = oficialRepository.createAChannel(name);
        if (created == null) {
        throw new ChannelNotFoundException();
    }
    return created;

    
}


}
