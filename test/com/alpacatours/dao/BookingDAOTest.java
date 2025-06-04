import com.alpacatours.dao.BookingDAO;
import com.alpacatours.model.Booking;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class BookingDAOTest {
    @Test
    public void testSaveAndFindAll() {
        BookingDAO dao = new BookingDAO();
        Booking b = new Booking();
        b.setUserId(1);
        b.setTourId(2);
        b.setNumPeople(3);
        b.setBookingDate(new Date(System.currentTimeMillis()));
        dao.save(b);
        assertEquals(1, dao.findAll().size());
        Booking stored = dao.findAll().get(0);
        assertEquals(2, stored.getTourId());
        assertEquals(3, stored.getNumPeople());
    }
}
