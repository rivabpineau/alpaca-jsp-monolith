import com.alpacatours.dao.TourDAO;
import com.alpacatours.model.Tour;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourDAOTest {
    @Test
    public void testSaveAndFind() {
        TourDAO dao = new TourDAO();
        Tour tour = new Tour();
        tour.setTitle("City Tour");
        dao.save(tour);
        assertEquals(1, dao.findAll().size());
        Tour found = dao.findById(tour.getId());
        assertNotNull(found);
        assertEquals("City Tour", found.getTitle());
    }
}
