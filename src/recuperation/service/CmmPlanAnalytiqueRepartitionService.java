package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmPlanAnalytiqueRepartition;
import com.yewi.yewicore.recuperation.dtos.CmmPlanAnalytiqueRepartitionDTO;
import com.yewi.yewicore.recuperation.repository.CmmPlanAnalytiqueRepartitionRepository;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmPlanAnalytiqueRepartitionService {

    @Autowired
    private CmmPlanAnalytiqueRepartitionRepository cmmPlanAnalytiqueRepartitionRepository;

    public Long save(CmmPlanAnalytiqueRepartitionVO vO) {
        CmmPlanAnalytiqueRepartition bean = new CmmPlanAnalytiqueRepartition();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmPlanAnalytiqueRepartitionRepository.save(bean);
        return bean.getCleId();
    }

    public void delete(Long id) {
        cmmPlanAnalytiqueRepartitionRepository.deleteById(id);
    }

    public void update(Long id, CmmPlanAnalytiqueRepartitionUpdateVO vO) {
        CmmPlanAnalytiqueRepartition bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmPlanAnalytiqueRepartitionRepository.save(bean);
    }

    public CmmPlanAnalytiqueRepartitionDTO getById(Long id) {
        CmmPlanAnalytiqueRepartition original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmPlanAnalytiqueRepartitionDTO> query(CmmPlanAnalytiqueRepartitionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmPlanAnalytiqueRepartitionDTO toDTO(CmmPlanAnalytiqueRepartition original) {
        CmmPlanAnalytiqueRepartitionDTO bean = new CmmPlanAnalytiqueRepartitionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmPlanAnalytiqueRepartition requireOne(Long id) {
        return cmmPlanAnalytiqueRepartitionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
