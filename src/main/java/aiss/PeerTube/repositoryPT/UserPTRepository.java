package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.modelPT.channel.OwnerAccountPT;
import aiss.PeerTube.services.UserPTService;

@Repository
public class UserPTRepository {
    @Autowired
    UserPTService userPTService;

    public OwnerAccountPT findUserByName(String userName) {
        OwnerAccountPT user = userPTService.findUserByName(userName);
        return user;
    }

    public List<OwnerAccountPT> findAllUsers() {
        return userPTService.findAllUsers();
    }


    
}
