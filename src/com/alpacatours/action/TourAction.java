package com.alpacatours.action;

import com.alpacatours.dao.TourDAO;
import com.alpacatours.model.Tour;
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
        List<Tour> tours = tourDAO.findAll();
        request.setAttribute("tours", tours);
        return mapping.findForward("success");
    }
}
