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

public class ProjSiteUpdate extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		long linkNo = Long.parseLong(request.getParameter("linkNo"));
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setMemNo(memNo);
		projDTO.setLinkNo(linkNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<ProjDTO> cat_list = projService.getCategoryList(projDTO);
			List<ProjDTO> site_list = projService.getSiteUpdateList(projDTO);
			mav.setViewName("/WEB-INF/views/siteUpdate.jsp");
			mav.addObject("cat_list", cat_list);
			mav.addObject("site_list", site_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}
