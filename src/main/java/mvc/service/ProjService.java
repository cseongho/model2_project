package mvc.service;

import java.util.List;
import mvc.models.ProjDTO;

public interface ProjService {

	void signupMember(ProjDTO projDTO) throws Exception;

	ProjDTO loginMember(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getCategoryList(ProjDTO projDTO) throws Exception;

	void categoryAdd(ProjDTO projDTO) throws Exception;

	void categoryDelete(ProjDTO projDTO) throws Exception;

	void categoryUpdate(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteList(ProjDTO projDTO) throws Exception;

	void siteAdd(ProjDTO projDTO) throws Exception;

	void siteDelete(ProjDTO projDTO) throws Exception;

	void siteUpdate(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteDetail(ProjDTO projDTO) throws Exception;

}
