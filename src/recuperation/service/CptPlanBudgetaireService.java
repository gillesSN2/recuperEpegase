package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptPlanBudgetaire;
import com.yewi.yewicore.recuperation.dtos.CptPlanBudgetaireDTO;
import com.yewi.yewicore.recuperation.repository.CptPlanBudgetaireRepository;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptPlanBudgetaireService {

    @Autowired
    private CptPlanBudgetaireRepository cptPlanBudgetaireRepository;

    public Long save(CptPlanBudgetaireVO vO) {
        CptPlanBudgetaire bean = new CptPlanBudgetaire();
        BeanUtils.copyProperties(vO, bean);
        bean = cptPlanBudgetaireRepository.save(bean);
        return bean.getPlbId();
    }

    public void delete(Long id) {
        cptPlanBudgetaireRepository.deleteById(id);
    }

    public void update(Long id, CptPlanBudgetaireUpdateVO vO) {
        CptPlanBudgetaire bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptPlanBudgetaireRepository.save(bean);
    }

    public CptPlanBudgetaireDTO getById(Long id) {
        CptPlanBudgetaire original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptPlanBudgetaireDTO> query(CptPlanBudgetaireQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptPlanBudgetaireDTO toDTO(CptPlanBudgetaire original) {
        CptPlanBudgetaireDTO bean = new CptPlanBudgetaireDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptPlanBudgetaire requireOne(Long id) {
        return cptPlanBudgetaireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
