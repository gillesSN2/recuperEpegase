package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiTraiteLigne;
import com.yewi.yewicore.recuperation.dtos.CaiTraiteLigneDTO;
import com.yewi.yewicore.recuperation.repository.CaiTraiteLigneRepository;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiTraiteLigneService {

    @Autowired
    private CaiTraiteLigneRepository caiTraiteLigneRepository;

    public Long save(CaiTraiteLigneVO vO) {
        CaiTraiteLigne bean = new CaiTraiteLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = caiTraiteLigneRepository.save(bean);
        return bean.getTrtligId();
    }

    public void delete(Long id) {
        caiTraiteLigneRepository.deleteById(id);
    }

    public void update(Long id, CaiTraiteLigneUpdateVO vO) {
        CaiTraiteLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiTraiteLigneRepository.save(bean);
    }

    public CaiTraiteLigneDTO getById(Long id) {
        CaiTraiteLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiTraiteLigneDTO> query(CaiTraiteLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiTraiteLigneDTO toDTO(CaiTraiteLigne original) {
        CaiTraiteLigneDTO bean = new CaiTraiteLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiTraiteLigne requireOne(Long id) {
        return caiTraiteLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
