package mvc.service;

import java.util.List;

import mvc.models.ProjDAO;
import mvc.models.ProjDAOImpl;
import mvc.models.ProjDTO;

public class ProjServiceImpl implements ProjService {
	private static final ProjService projService = new ProjServiceImpl();
	private ProjDAO projDAO = ProjDAOImpl.getInstance();
	
	private ProjServiceImpl() {
		
	}
	
	public static ProjService getInstance() {
		return projService;
	}

	@Override
	public void signupMember(ProjDTO projDTO) throws Exception {
		if(projDAO.signupMember(projDTO) != 1) {
			throw new RuntimeException("실패");
		}
	}

	@Override
	public ProjDTO loginMember(ProjDTO projDTO) throws Exception {
		if(projDAO.loginMember(projDTO) != null) {
			return projDTO;
		}else {
			throw new RuntimeException("로그인 실패");
		}
	}

	@Override
	public List<ProjDTO> getCategoryList(ProjDTO projDTO) throws Exception{
		return projDAO.getCategoryList(projDTO);
	}

	@Override
	public void categoryAdd(ProjDTO projDTO) throws Exception {
		if(projDAO.categoryAdd(projDTO) != 1) {
			throw new RuntimeException("카테고리 추가 오류");
		}
	}

	@Override
	public void categoryDelete(ProjDTO projDTO) throws Exception {
		projDAO.categoryDelete(projDTO);
	}

	@Override
	public void categoryUpdate(ProjDTO projDTO) throws Exception {
		projDAO.categoryUpdate(projDTO);
		
	}

	@Override
	public List<ProjDTO> getSiteList(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteList(projDTO);
	}

	@Override
	public void siteAdd(ProjDTO projDTO) throws Exception {
		if(projDAO.siteAdd(projDTO) != 1) {
			throw new RuntimeException("사이트 추가 오류");
		}
		
	}

	@Override
	public void siteDelete(ProjDTO projDTO) throws Exception {
		projDAO.siteDelete(projDTO);
	}

	@Override
	public void siteUpdate(ProjDTO projDTO) throws Exception {
		projDAO.siteUpdate(projDTO);
		
	}

	@Override
	public List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteUpdateList(projDTO);
	}

	@Override
	public List<ProjDTO> getSiteDetail(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteUpdateList(projDTO);
	}
	

}
