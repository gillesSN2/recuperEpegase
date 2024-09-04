package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiVirementInterne;
import com.yewi.yewicore.recuperation.dtos.CaiVirementInterneDTO;
import com.yewi.yewicore.recuperation.repository.CaiVirementInterneRepository;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiVirementInterneService {

    @Autowired
    private CaiVirementInterneRepository caiVirementInterneRepository;

    public Long save(CaiVirementInterneVO vO) {
        CaiVirementInterne bean = new CaiVirementInterne();
        BeanUtils.copyProperties(vO, bean);
        bean = caiVirementInterneRepository.save(bean);
        return bean.getVirId();
    }

    public void delete(Long id) {
        caiVirementInterneRepository.deleteById(id);
    }

    public void update(Long id, CaiVirementInterneUpdateVO vO) {
        CaiVirementInterne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiVirementInterneRepository.save(bean);
    }

    public CaiVirementInterneDTO getById(Long id) {
        CaiVirementInterne original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiVirementInterneDTO> query(CaiVirementInterneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiVirementInterneDTO toDTO(CaiVirementInterne original) {
        CaiVirementInterneDTO bean = new CaiVirementInterneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiVirementInterne requireOne(Long id) {
        return caiVirementInterneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
