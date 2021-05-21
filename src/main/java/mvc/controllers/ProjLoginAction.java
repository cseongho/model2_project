package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ProjDTO;
import mvc.service.ProjService;
import mvc.service.ProjServiceImpl;

public class ProjLoginAction extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setId(id);
		projDTO.setPwd(pwd);
		
		ModelAndView mav = new ModelAndView();
		try {
			projDTO = projService.loginMember(projDTO); 
			mav.setViewName("main");
			HttpSession session = request.getSession(true);
			String member_no = Long.toString(projDTO.getMemNo());
			session.setAttribute("member_no", member_no);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "로그인에 실패 하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
}
