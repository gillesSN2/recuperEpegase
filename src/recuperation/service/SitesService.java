package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Sites;
import com.yewi.yewicore.recuperation.dtos.SitesDTO;
import com.yewi.yewicore.recuperation.repository.SitesRepository;
import com.yewi.yewicore.recuperation.vo.SitesQueryVO;
import com.yewi.yewicore.recuperation.vo.SitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.SitesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SitesService {

    @Autowired
    private SitesRepository sitesRepository;

    public Long save(SitesVO vO) {
        Sites bean = new Sites();
        BeanUtils.copyProperties(vO, bean);
        bean = sitesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        sitesRepository.deleteById(id);
    }

    public void update(Long id, SitesUpdateVO vO) {
        Sites bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sitesRepository.save(bean);
    }

    public SitesDTO getById(Long id) {
        Sites original = requireOne(id);
        return toDTO(original);
    }

    public Page<SitesDTO> query(SitesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SitesDTO toDTO(Sites original) {
        SitesDTO bean = new SitesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Sites requireOne(Long id) {
        return sitesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
