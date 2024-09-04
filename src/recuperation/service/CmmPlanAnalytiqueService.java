package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmPlanAnalytique;
import com.yewi.yewicore.recuperation.dtos.CmmPlanAnalytiqueDTO;
import com.yewi.yewicore.recuperation.repository.CmmPlanAnalytiqueRepository;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmPlanAnalytiqueService {

    @Autowired
    private CmmPlanAnalytiqueRepository cmmPlanAnalytiqueRepository;

    public Long save(CmmPlanAnalytiqueVO vO) {
        CmmPlanAnalytique bean = new CmmPlanAnalytique();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmPlanAnalytiqueRepository.save(bean);
        return bean.getAnaId();
    }

    public void delete(Long id) {
        cmmPlanAnalytiqueRepository.deleteById(id);
    }

    public void update(Long id, CmmPlanAnalytiqueUpdateVO vO) {
        CmmPlanAnalytique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmPlanAnalytiqueRepository.save(bean);
    }

    public CmmPlanAnalytiqueDTO getById(Long id) {
        CmmPlanAnalytique original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmPlanAnalytiqueDTO> query(CmmPlanAnalytiqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmPlanAnalytiqueDTO toDTO(CmmPlanAnalytique original) {
        CmmPlanAnalytiqueDTO bean = new CmmPlanAnalytiqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmPlanAnalytique requireOne(Long id) {
        return cmmPlanAnalytiqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
