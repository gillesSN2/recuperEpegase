package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptBudget;
import com.yewi.yewicore.recuperation.dtos.CptBudgetDTO;
import com.yewi.yewicore.recuperation.repository.CptBudgetRepository;
import com.yewi.yewicore.recuperation.vo.CptBudgetQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptBudgetService {

    @Autowired
    private CptBudgetRepository cptBudgetRepository;

    public Long save(CptBudgetVO vO) {
        CptBudget bean = new CptBudget();
        BeanUtils.copyProperties(vO, bean);
        bean = cptBudgetRepository.save(bean);
        return bean.getBudId();
    }

    public void delete(Long id) {
        cptBudgetRepository.deleteById(id);
    }

    public void update(Long id, CptBudgetUpdateVO vO) {
        CptBudget bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptBudgetRepository.save(bean);
    }

    public CptBudgetDTO getById(Long id) {
        CptBudget original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptBudgetDTO> query(CptBudgetQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptBudgetDTO toDTO(CptBudget original) {
        CptBudgetDTO bean = new CptBudgetDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptBudget requireOne(Long id) {
        return cptBudgetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
