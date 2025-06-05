package com.alpacatours.action;

import com.alpacatours.dao.TourDAO;
import com.alpacatours.model.Tour;
import com.alpacatours.form.TourForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

public class TourAction extends Action {
    private final TourDAO tourDAO = new TourDAO();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = mapping.getPath();
        if ("/addTour".equals(action)) {
            TourForm tf = (TourForm) form;
            Tour tour = new Tour();
            tour.setTitle(tf.getTitle());
            tour.setLocation(tf.getLocation());
            tour.setPrice(tf.getPrice());
            tour.setDescription(tf.getDescription());
            tour.setCapacity(tf.getCapacity());
            tour.setGuideId(tf.getGuideId());
            tourDAO.save(tour);
        }
        List<Tour> tours = tourDAO.findAll();
        request.setAttribute("tours", tours);
        return mapping.findForward("success");
    }
}
