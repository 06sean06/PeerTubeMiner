package aiss.PeerTube.services;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertFalse(users.isEmpty(), "La lista de usuarios no debería estar vacía");
        OwnerAccountPT first = users.get(0);
        assertNotNull(first.getId(), "El ID del usuario no puede ser nulo");
        assertNotNull(first.getName(), "El nombre del usuario no puede ser nulo");
        assertNotNull(first.getUrl(), "La URL del usuario no puede ser nula");
        assertTrue(first.getUrl().startsWith("http"), "La URL debe ser un enlace válido");
    }

    @Test
    @DisplayName("Get a user by name (flo200@www.yiny.org)")
    void testFindUserByName() {
        OwnerAccountPT user = userPTService.findUserByName("flo200@www.yiny.org");
        assertFalse(user == null, "The user should not be null");
        assertEquals("flo200", user.getName(), "El nombre técnico debería ser 'flo200'");
        assertNotNull(user.getDisplayName(), "El nombre público no debería ser nulo");
        assertNotNull(user.getCreatedAt(), "Debería tener fecha de creación");
        assertTrue(user.getUrl().contains("yiny.org"), "La URL del usuario debería pertenecer a su instancia");
    }
}
