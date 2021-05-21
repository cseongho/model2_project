package mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ProjDTO;
import mvc.service.ProjService;
import mvc.service.ProjServiceImpl;

public class ProjSite extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		long catNo = Long.parseLong(request.getParameter("no"));
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setCatNo(catNo);
		projDTO.setMemNo(memNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<ProjDTO> cat_list = projService.getCategoryList(projDTO);
			List<ProjDTO> site_list = projService.getSiteList(projDTO);
			
			mav.setViewName("/WEB-INF/views/site.jsp");
			mav.addObject("cat_list", cat_list);
			mav.addObject("site_list", site_list);
			//mav.addObject("parse_site_list", parse_site_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}
