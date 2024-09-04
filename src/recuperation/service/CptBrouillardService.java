package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptBrouillard;
import com.yewi.yewicore.recuperation.dtos.CptBrouillardDTO;
import com.yewi.yewicore.recuperation.repository.CptBrouillardRepository;
import com.yewi.yewicore.recuperation.vo.CptBrouillardQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBrouillardUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBrouillardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptBrouillardService {

    @Autowired
    private CptBrouillardRepository cptBrouillardRepository;

    public Long save(CptBrouillardVO vO) {
        CptBrouillard bean = new CptBrouillard();
        BeanUtils.copyProperties(vO, bean);
        bean = cptBrouillardRepository.save(bean);
        return bean.getBroId();
    }

    public void delete(Long id) {
        cptBrouillardRepository.deleteById(id);
    }

    public void update(Long id, CptBrouillardUpdateVO vO) {
        CptBrouillard bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptBrouillardRepository.save(bean);
    }

    public CptBrouillardDTO getById(Long id) {
        CptBrouillard original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptBrouillardDTO> query(CptBrouillardQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptBrouillardDTO toDTO(CptBrouillard original) {
        CptBrouillardDTO bean = new CptBrouillardDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptBrouillard requireOne(Long id) {
        return cptBrouillardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
