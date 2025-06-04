import com.alpacatours.dao.UserDAO;
import com.alpacatours.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
    @Test
    public void testSaveAndFindByUsername() {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setUsername("alice");
        user.setPassword("secret");
        dao.save(user);
        User found = dao.findByUsername("alice");
        assertNotNull(found);
        assertEquals("alice", found.getUsername());
        assertEquals("secret", found.getPassword());
    }
}
