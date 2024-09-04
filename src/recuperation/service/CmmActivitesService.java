package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmActivites;
import com.yewi.yewicore.recuperation.dtos.CmmActivitesDTO;
import com.yewi.yewicore.recuperation.repository.CmmActivitesRepository;
import com.yewi.yewicore.recuperation.vo.CmmActivitesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmActivitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmActivitesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmActivitesService {

    @Autowired
    private CmmActivitesRepository cmmActivitesRepository;

    public Long save(CmmActivitesVO vO) {
        CmmActivites bean = new CmmActivites();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmActivitesRepository.save(bean);
        return bean.getActId();
    }

    public void delete(Long id) {
        cmmActivitesRepository.deleteById(id);
    }

    public void update(Long id, CmmActivitesUpdateVO vO) {
        CmmActivites bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmActivitesRepository.save(bean);
    }

    public CmmActivitesDTO getById(Long id) {
        CmmActivites original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmActivitesDTO> query(CmmActivitesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmActivitesDTO toDTO(CmmActivites original) {
        CmmActivitesDTO bean = new CmmActivitesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmActivites requireOne(Long id) {
        return cmmActivitesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
