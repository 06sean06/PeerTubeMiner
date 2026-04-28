package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.UserNotFoundException;
import aiss.PeerTube.model.modelPT.channel.OwnerAccountPT;
import aiss.PeerTube.repositoryPT.UserPTRepository;

@RestController
@RequestMapping("PeerTube/accounts")
public class UserPTController {
    private UserPTRepository userRepository;

    public UserPTController(UserPTRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET http://localhost:8080/PeerTube/accounts
    @GetMapping
    public List<OwnerAccountPT> getUsers() {
        return userRepository.findAllUsers();
    }

    // GET http://localhost:8080/PeerTube/accounts/{userName}
    @GetMapping("/{userName}")
    public OwnerAccountPT getUserByName(@PathVariable String userName) throws UserNotFoundException {
        return userRepository.findUserByName(userName);
    }
    
}
