package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptPlanTresorerie;
import com.yewi.yewicore.recuperation.dtos.CptPlanTresorerieDTO;
import com.yewi.yewicore.recuperation.repository.CptPlanTresorerieRepository;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptPlanTresorerieService {

    @Autowired
    private CptPlanTresorerieRepository cptPlanTresorerieRepository;

    public Long save(CptPlanTresorerieVO vO) {
        CptPlanTresorerie bean = new CptPlanTresorerie();
        BeanUtils.copyProperties(vO, bean);
        bean = cptPlanTresorerieRepository.save(bean);
        return bean.getTreId();
    }

    public void delete(Long id) {
        cptPlanTresorerieRepository.deleteById(id);
    }

    public void update(Long id, CptPlanTresorerieUpdateVO vO) {
        CptPlanTresorerie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptPlanTresorerieRepository.save(bean);
    }

    public CptPlanTresorerieDTO getById(Long id) {
        CptPlanTresorerie original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptPlanTresorerieDTO> query(CptPlanTresorerieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptPlanTresorerieDTO toDTO(CptPlanTresorerie original) {
        CptPlanTresorerieDTO bean = new CptPlanTresorerieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptPlanTresorerie requireOne(Long id) {
        return cptPlanTresorerieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
