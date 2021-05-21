package mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ProjDTO;
import mvc.service.ProjService;
import mvc.service.ProjServiceImpl;

public class ProjSignupAction extends AbstractController{

	ProjService projService = ProjServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		ProjDTO projDTO = new ProjDTO();
		projDTO.setId(id);
		projDTO.setPwd(pwd);
		projDTO.setEmail(email);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.signupMember(projDTO);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", projDTO.getId()+"님 회원가입이 완료 되었습니다.");
			mav.addObject("url", "login");
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "회원가입이 실패 하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
	}
	
}
