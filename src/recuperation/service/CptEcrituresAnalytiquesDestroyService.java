package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnalytiquesDestroy;
import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnalytiquesDestroyDTO;
import com.yewi.yewicore.recuperation.repository.CptEcrituresAnalytiquesDestroyRepository;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptEcrituresAnalytiquesDestroyService {

    @Autowired
    private CptEcrituresAnalytiquesDestroyRepository cptEcrituresAnalytiquesDestroyRepository;

    public Long save(CptEcrituresAnalytiquesDestroyVO vO) {
        CptEcrituresAnalytiquesDestroy bean = new CptEcrituresAnalytiquesDestroy();
        BeanUtils.copyProperties(vO, bean);
        bean = cptEcrituresAnalytiquesDestroyRepository.save(bean);
        return bean.getEcranaId();
    }

    public void delete(Long id) {
        cptEcrituresAnalytiquesDestroyRepository.deleteById(id);
    }

    public void update(Long id, CptEcrituresAnalytiquesDestroyUpdateVO vO) {
        CptEcrituresAnalytiquesDestroy bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptEcrituresAnalytiquesDestroyRepository.save(bean);
    }

    public CptEcrituresAnalytiquesDestroyDTO getById(Long id) {
        CptEcrituresAnalytiquesDestroy original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptEcrituresAnalytiquesDestroyDTO> query(CptEcrituresAnalytiquesDestroyQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptEcrituresAnalytiquesDestroyDTO toDTO(CptEcrituresAnalytiquesDestroy original) {
        CptEcrituresAnalytiquesDestroyDTO bean = new CptEcrituresAnalytiquesDestroyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptEcrituresAnalytiquesDestroy requireOne(Long id) {
        return cptEcrituresAnalytiquesDestroyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
