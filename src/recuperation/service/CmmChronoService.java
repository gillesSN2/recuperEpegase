package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmChrono;
import com.yewi.yewicore.recuperation.dtos.CmmChronoDTO;
import com.yewi.yewicore.recuperation.repository.CmmChronoRepository;
import com.yewi.yewicore.recuperation.vo.CmmChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmChronoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmChronoService {

    @Autowired
    private CmmChronoRepository cmmChronoRepository;

    public Long save(CmmChronoVO vO) {
        CmmChrono bean = new CmmChrono();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmChronoRepository.save(bean);
        return bean.getChrId();
    }

    public void delete(Long id) {
        cmmChronoRepository.deleteById(id);
    }

    public void update(Long id, CmmChronoUpdateVO vO) {
        CmmChrono bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmChronoRepository.save(bean);
    }

    public CmmChronoDTO getById(Long id) {
        CmmChrono original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmChronoDTO> query(CmmChronoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmChronoDTO toDTO(CmmChrono original) {
        CmmChronoDTO bean = new CmmChronoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmChrono requireOne(Long id) {
        return cmmChronoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
