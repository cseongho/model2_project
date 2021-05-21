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

public class ProjSiteAddAction extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		Long catNo = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String link = request.getParameter("link");
		String content = request.getParameter("content");
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setMemNo(memNo);
		projDTO.setTitle(title);
		projDTO.setLink(link);
		projDTO.setContent(content);
		projDTO.setCatNo(catNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.siteAdd(projDTO);
			mav.setViewName("site?no="+catNo);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
}
