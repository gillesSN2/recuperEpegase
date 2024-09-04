package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmReunionPresence;
import com.yewi.yewicore.recuperation.dtos.CmmReunionPresenceDTO;
import com.yewi.yewicore.recuperation.repository.CmmReunionPresenceRepository;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmReunionPresenceService {

    @Autowired
    private CmmReunionPresenceRepository cmmReunionPresenceRepository;

    public Long save(CmmReunionPresenceVO vO) {
        CmmReunionPresence bean = new CmmReunionPresence();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmReunionPresenceRepository.save(bean);
        return bean.getReupreId();
    }

    public void delete(Long id) {
        cmmReunionPresenceRepository.deleteById(id);
    }

    public void update(Long id, CmmReunionPresenceUpdateVO vO) {
        CmmReunionPresence bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmReunionPresenceRepository.save(bean);
    }

    public CmmReunionPresenceDTO getById(Long id) {
        CmmReunionPresence original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmReunionPresenceDTO> query(CmmReunionPresenceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmReunionPresenceDTO toDTO(CmmReunionPresence original) {
        CmmReunionPresenceDTO bean = new CmmReunionPresenceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmReunionPresence requireOne(Long id) {
        return cmmReunionPresenceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
