package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmRegion;
import com.yewi.yewicore.recuperation.dtos.CmmRegionDTO;
import com.yewi.yewicore.recuperation.repository.CmmRegionRepository;
import com.yewi.yewicore.recuperation.vo.CmmRegionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmRegionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmRegionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmRegionService {

    @Autowired
    private CmmRegionRepository cmmRegionRepository;

    public Long save(CmmRegionVO vO) {
        CmmRegion bean = new CmmRegion();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmRegionRepository.save(bean);
        return bean.getRegId();
    }

    public void delete(Long id) {
        cmmRegionRepository.deleteById(id);
    }

    public void update(Long id, CmmRegionUpdateVO vO) {
        CmmRegion bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmRegionRepository.save(bean);
    }

    public CmmRegionDTO getById(Long id) {
        CmmRegion original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmRegionDTO> query(CmmRegionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmRegionDTO toDTO(CmmRegion original) {
        CmmRegionDTO bean = new CmmRegionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmRegion requireOne(Long id) {
        return cmmRegionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
