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

public class ProjCategoryAdd extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setMemNo(memNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<ProjDTO> cat_list = projService.getCategoryList(projDTO);
			mav.setViewName("/WEB-INF/views/categoryAdd.jsp");
			mav.addObject("cat_list", cat_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}
