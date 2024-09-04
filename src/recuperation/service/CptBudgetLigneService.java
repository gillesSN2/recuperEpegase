package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptBudgetLigne;
import com.yewi.yewicore.recuperation.dtos.CptBudgetLigneDTO;
import com.yewi.yewicore.recuperation.repository.CptBudgetLigneRepository;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptBudgetLigneService {

    @Autowired
    private CptBudgetLigneRepository cptBudgetLigneRepository;

    public Long save(CptBudgetLigneVO vO) {
        CptBudgetLigne bean = new CptBudgetLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = cptBudgetLigneRepository.save(bean);
        return bean.getBudligId();
    }

    public void delete(Long id) {
        cptBudgetLigneRepository.deleteById(id);
    }

    public void update(Long id, CptBudgetLigneUpdateVO vO) {
        CptBudgetLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptBudgetLigneRepository.save(bean);
    }

    public CptBudgetLigneDTO getById(Long id) {
        CptBudgetLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptBudgetLigneDTO> query(CptBudgetLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptBudgetLigneDTO toDTO(CptBudgetLigne original) {
        CptBudgetLigneDTO bean = new CptBudgetLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptBudgetLigne requireOne(Long id) {
        return cptBudgetLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
