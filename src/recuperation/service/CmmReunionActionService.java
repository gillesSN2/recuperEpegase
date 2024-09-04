package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmReunionAction;
import com.yewi.yewicore.recuperation.dtos.CmmReunionActionDTO;
import com.yewi.yewicore.recuperation.repository.CmmReunionActionRepository;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmReunionActionService {

    @Autowired
    private CmmReunionActionRepository cmmReunionActionRepository;

    public Long save(CmmReunionActionVO vO) {
        CmmReunionAction bean = new CmmReunionAction();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmReunionActionRepository.save(bean);
        return bean.getReuactId();
    }

    public void delete(Long id) {
        cmmReunionActionRepository.deleteById(id);
    }

    public void update(Long id, CmmReunionActionUpdateVO vO) {
        CmmReunionAction bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmReunionActionRepository.save(bean);
    }

    public CmmReunionActionDTO getById(Long id) {
        CmmReunionAction original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmReunionActionDTO> query(CmmReunionActionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmReunionActionDTO toDTO(CmmReunionAction original) {
        CmmReunionActionDTO bean = new CmmReunionActionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmReunionAction requireOne(Long id) {
        return cmmReunionActionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
