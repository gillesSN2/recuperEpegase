package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmGroupeChrono;
import com.yewi.yewicore.recuperation.dtos.CmmGroupeChronoDTO;
import com.yewi.yewicore.recuperation.repository.CmmGroupeChronoRepository;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmGroupeChronoService {

    @Autowired
    private CmmGroupeChronoRepository cmmGroupeChronoRepository;

    public Long save(CmmGroupeChronoVO vO) {
        CmmGroupeChrono bean = new CmmGroupeChrono();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmGroupeChronoRepository.save(bean);
        return bean.getGrpchrId();
    }

    public void delete(Long id) {
        cmmGroupeChronoRepository.deleteById(id);
    }

    public void update(Long id, CmmGroupeChronoUpdateVO vO) {
        CmmGroupeChrono bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmGroupeChronoRepository.save(bean);
    }

    public CmmGroupeChronoDTO getById(Long id) {
        CmmGroupeChrono original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmGroupeChronoDTO> query(CmmGroupeChronoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmGroupeChronoDTO toDTO(CmmGroupeChrono original) {
        CmmGroupeChronoDTO bean = new CmmGroupeChronoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmGroupeChrono requireOne(Long id) {
        return cmmGroupeChronoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
