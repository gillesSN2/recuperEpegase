package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmResponsable;
import com.yewi.yewicore.recuperation.dtos.CmmResponsableDTO;
import com.yewi.yewicore.recuperation.repository.CmmResponsableRepository;
import com.yewi.yewicore.recuperation.vo.CmmResponsableQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmResponsableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmResponsableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmResponsableService {

    @Autowired
    private CmmResponsableRepository cmmResponsableRepository;

    public Long save(CmmResponsableVO vO) {
        CmmResponsable bean = new CmmResponsable();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmResponsableRepository.save(bean);
        return bean.getRpbId();
    }

    public void delete(Long id) {
        cmmResponsableRepository.deleteById(id);
    }

    public void update(Long id, CmmResponsableUpdateVO vO) {
        CmmResponsable bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmResponsableRepository.save(bean);
    }

    public CmmResponsableDTO getById(Long id) {
        CmmResponsable original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmResponsableDTO> query(CmmResponsableQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmResponsableDTO toDTO(CmmResponsable original) {
        CmmResponsableDTO bean = new CmmResponsableDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmResponsable requireOne(Long id) {
        return cmmResponsableRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
