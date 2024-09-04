package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptBudgetTresorerieLigne;
import com.yewi.yewicore.recuperation.dtos.CptBudgetTresorerieLigneDTO;
import com.yewi.yewicore.recuperation.repository.CptBudgetTresorerieLigneRepository;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptBudgetTresorerieLigneService {

    @Autowired
    private CptBudgetTresorerieLigneRepository cptBudgetTresorerieLigneRepository;

    public Long save(CptBudgetTresorerieLigneVO vO) {
        CptBudgetTresorerieLigne bean = new CptBudgetTresorerieLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = cptBudgetTresorerieLigneRepository.save(bean);
        return bean.getBudligId();
    }

    public void delete(Long id) {
        cptBudgetTresorerieLigneRepository.deleteById(id);
    }

    public void update(Long id, CptBudgetTresorerieLigneUpdateVO vO) {
        CptBudgetTresorerieLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptBudgetTresorerieLigneRepository.save(bean);
    }

    public CptBudgetTresorerieLigneDTO getById(Long id) {
        CptBudgetTresorerieLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptBudgetTresorerieLigneDTO> query(CptBudgetTresorerieLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptBudgetTresorerieLigneDTO toDTO(CptBudgetTresorerieLigne original) {
        CptBudgetTresorerieLigneDTO bean = new CptBudgetTresorerieLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptBudgetTresorerieLigne requireOne(Long id) {
        return cptBudgetTresorerieLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
