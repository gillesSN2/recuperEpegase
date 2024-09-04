package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmEspion;
import com.yewi.yewicore.recuperation.dtos.CmmEspionDTO;
import com.yewi.yewicore.recuperation.repository.CmmEspionRepository;
import com.yewi.yewicore.recuperation.vo.CmmEspionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmEspionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmEspionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmEspionService {

    @Autowired
    private CmmEspionRepository cmmEspionRepository;

    public Long save(CmmEspionVO vO) {
        CmmEspion bean = new CmmEspion();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmEspionRepository.save(bean);
        return bean.getEspId();
    }

    public void delete(Long id) {
        cmmEspionRepository.deleteById(id);
    }

    public void update(Long id, CmmEspionUpdateVO vO) {
        CmmEspion bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmEspionRepository.save(bean);
    }

    public CmmEspionDTO getById(Long id) {
        CmmEspion original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmEspionDTO> query(CmmEspionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmEspionDTO toDTO(CmmEspion original) {
        CmmEspionDTO bean = new CmmEspionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmEspion requireOne(Long id) {
        return cmmEspionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
