package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ProjDTO;
import mvc.service.ProjService;
import mvc.service.ProjServiceImpl;

public class ProjSiteDeleteAction extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		long linkNo = Long.parseLong(request.getParameter("linkNo"));
		long catNo = Long.parseLong(request.getParameter("catNo"));
			
		ProjDTO projDTO = new ProjDTO();
		projDTO.setMemNo(memNo);
		projDTO.setLinkNo(linkNo);
		projDTO.setCatNo(catNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.siteDelete(projDTO);
			mav.setViewName("site?no="+catNo);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
}
