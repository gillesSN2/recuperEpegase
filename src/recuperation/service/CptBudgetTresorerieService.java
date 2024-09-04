package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptBudgetTresorerie;
import com.yewi.yewicore.recuperation.dtos.CptBudgetTresorerieDTO;
import com.yewi.yewicore.recuperation.repository.CptBudgetTresorerieRepository;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptBudgetTresorerieService {

    @Autowired
    private CptBudgetTresorerieRepository cptBudgetTresorerieRepository;

    public Long save(CptBudgetTresorerieVO vO) {
        CptBudgetTresorerie bean = new CptBudgetTresorerie();
        BeanUtils.copyProperties(vO, bean);
        bean = cptBudgetTresorerieRepository.save(bean);
        return bean.getBudId();
    }

    public void delete(Long id) {
        cptBudgetTresorerieRepository.deleteById(id);
    }

    public void update(Long id, CptBudgetTresorerieUpdateVO vO) {
        CptBudgetTresorerie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptBudgetTresorerieRepository.save(bean);
    }

    public CptBudgetTresorerieDTO getById(Long id) {
        CptBudgetTresorerie original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptBudgetTresorerieDTO> query(CptBudgetTresorerieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptBudgetTresorerieDTO toDTO(CptBudgetTresorerie original) {
        CptBudgetTresorerieDTO bean = new CptBudgetTresorerieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptBudgetTresorerie requireOne(Long id) {
        return cptBudgetTresorerieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
