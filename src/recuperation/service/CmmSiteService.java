package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmSite;
import com.yewi.yewicore.recuperation.dtos.CmmSiteDTO;
import com.yewi.yewicore.recuperation.repository.CmmSiteRepository;
import com.yewi.yewicore.recuperation.vo.CmmSiteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSiteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSiteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmSiteService {

    @Autowired
    private CmmSiteRepository cmmSiteRepository;

    public Long save(CmmSiteVO vO) {
        CmmSite bean = new CmmSite();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmSiteRepository.save(bean);
        return bean.getSitId();
    }

    public void delete(Long id) {
        cmmSiteRepository.deleteById(id);
    }

    public void update(Long id, CmmSiteUpdateVO vO) {
        CmmSite bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmSiteRepository.save(bean);
    }

    public CmmSiteDTO getById(Long id) {
        CmmSite original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmSiteDTO> query(CmmSiteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmSiteDTO toDTO(CmmSite original) {
        CmmSiteDTO bean = new CmmSiteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmSite requireOne(Long id) {
        return cmmSiteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
