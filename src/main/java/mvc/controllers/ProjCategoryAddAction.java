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

public class ProjCategoryAddAction extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		String name = request.getParameter("name");
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setMemNo(memNo);
		projDTO.setName(name);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.categoryAdd(projDTO);
			mav.setViewName("categoryAdd");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
}
