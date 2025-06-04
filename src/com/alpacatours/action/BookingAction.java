package com.alpacatours.action;

import com.alpacatours.dao.BookingDAO;
import com.alpacatours.form.BookingForm;
import com.alpacatours.model.Booking;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.Date;

public class BookingAction extends Action {
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookingForm bookingForm = (BookingForm) form;
        Booking booking = new Booking();
        booking.setTourId(bookingForm.getTourId());
        booking.setNumPeople(bookingForm.getNumPeople());
        booking.setBookingDate(new Date(System.currentTimeMillis()));
        bookingDAO.save(booking);
        return mapping.findForward("success");
    }
}
