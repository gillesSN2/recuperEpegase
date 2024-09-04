package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmHabilitation;
import com.yewi.yewicore.recuperation.dtos.CmmHabilitationDTO;
import com.yewi.yewicore.recuperation.repository.CmmHabilitationRepository;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmHabilitationService {

    @Autowired
    private CmmHabilitationRepository cmmHabilitationRepository;

    public Long save(CmmHabilitationVO vO) {
        CmmHabilitation bean = new CmmHabilitation();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmHabilitationRepository.save(bean);
        return bean.getHabId();
    }

    public void delete(Long id) {
        cmmHabilitationRepository.deleteById(id);
    }

    public void update(Long id, CmmHabilitationUpdateVO vO) {
        CmmHabilitation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmHabilitationRepository.save(bean);
    }

    public CmmHabilitationDTO getById(Long id) {
        CmmHabilitation original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmHabilitationDTO> query(CmmHabilitationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmHabilitationDTO toDTO(CmmHabilitation original) {
        CmmHabilitationDTO bean = new CmmHabilitationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmHabilitation requireOne(Long id) {
        return cmmHabilitationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
