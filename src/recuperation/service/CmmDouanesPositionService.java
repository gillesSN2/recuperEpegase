package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmDouanesPosition;
import com.yewi.yewicore.recuperation.dtos.CmmDouanesPositionDTO;
import com.yewi.yewicore.recuperation.repository.CmmDouanesPositionRepository;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmDouanesPositionService {

    @Autowired
    private CmmDouanesPositionRepository cmmDouanesPositionRepository;

    public Long save(CmmDouanesPositionVO vO) {
        CmmDouanesPosition bean = new CmmDouanesPosition();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmDouanesPositionRepository.save(bean);
        return bean.getDouposId();
    }

    public void delete(Long id) {
        cmmDouanesPositionRepository.deleteById(id);
    }

    public void update(Long id, CmmDouanesPositionUpdateVO vO) {
        CmmDouanesPosition bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmDouanesPositionRepository.save(bean);
    }

    public CmmDouanesPositionDTO getById(Long id) {
        CmmDouanesPosition original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmDouanesPositionDTO> query(CmmDouanesPositionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmDouanesPositionDTO toDTO(CmmDouanesPosition original) {
        CmmDouanesPositionDTO bean = new CmmDouanesPositionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmDouanesPosition requireOne(Long id) {
        return cmmDouanesPositionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
