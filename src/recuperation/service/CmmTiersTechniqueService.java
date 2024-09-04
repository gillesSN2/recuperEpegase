package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmTiersTechnique;
import com.yewi.yewicore.recuperation.dtos.CmmTiersTechniqueDTO;
import com.yewi.yewicore.recuperation.repository.CmmTiersTechniqueRepository;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmTiersTechniqueService {

    @Autowired
    private CmmTiersTechniqueRepository cmmTiersTechniqueRepository;

    public Long save(CmmTiersTechniqueVO vO) {
        CmmTiersTechnique bean = new CmmTiersTechnique();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmTiersTechniqueRepository.save(bean);
        return bean.getTietecId();
    }

    public void delete(Long id) {
        cmmTiersTechniqueRepository.deleteById(id);
    }

    public void update(Long id, CmmTiersTechniqueUpdateVO vO) {
        CmmTiersTechnique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmTiersTechniqueRepository.save(bean);
    }

    public CmmTiersTechniqueDTO getById(Long id) {
        CmmTiersTechnique original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmTiersTechniqueDTO> query(CmmTiersTechniqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmTiersTechniqueDTO toDTO(CmmTiersTechnique original) {
        CmmTiersTechniqueDTO bean = new CmmTiersTechniqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmTiersTechnique requireOne(Long id) {
        return cmmTiersTechniqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
