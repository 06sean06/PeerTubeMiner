package aiss.PeerTube.services;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.channel.OwnerAccountPT;

@SpringBootTest
public class UserPTServiceTest {
    
    @Autowired
    UserPTService userPTService;

     @Test
    @DisplayName("Get all users")
    void testFindAllUsers() {
        
        List<OwnerAccountPT> users = userPTService.findAllUsers();
        assertFalse(users.isEmpty(), "The list of users should not be empty");
    }

        @Test
    @DisplayName("Get a user by name (flo200@www.yiny.org)")
    void testFindUserByName() {
        OwnerAccountPT user = userPTService.findUserByName("flo200@www.yiny.org");
        assertFalse(user == null, "The user should not be null");
    }

}
