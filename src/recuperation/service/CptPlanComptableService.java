package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptPlanComptable;
import com.yewi.yewicore.recuperation.dtos.CptPlanComptableDTO;
import com.yewi.yewicore.recuperation.repository.CptPlanComptableRepository;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptPlanComptableService {

    @Autowired
    private CptPlanComptableRepository cptPlanComptableRepository;

    public Long save(CptPlanComptableVO vO) {
        CptPlanComptable bean = new CptPlanComptable();
        BeanUtils.copyProperties(vO, bean);
        bean = cptPlanComptableRepository.save(bean);
        return bean.getPlcId();
    }

    public void delete(Long id) {
        cptPlanComptableRepository.deleteById(id);
    }

    public void update(Long id, CptPlanComptableUpdateVO vO) {
        CptPlanComptable bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptPlanComptableRepository.save(bean);
    }

    public CptPlanComptableDTO getById(Long id) {
        CptPlanComptable original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptPlanComptableDTO> query(CptPlanComptableQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptPlanComptableDTO toDTO(CptPlanComptable original) {
        CptPlanComptableDTO bean = new CptPlanComptableDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptPlanComptable requireOne(Long id) {
        return cptPlanComptableRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
