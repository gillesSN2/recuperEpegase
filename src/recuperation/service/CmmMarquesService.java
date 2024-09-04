package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmMarques;
import com.yewi.yewicore.recuperation.dtos.CmmMarquesDTO;
import com.yewi.yewicore.recuperation.repository.CmmMarquesRepository;
import com.yewi.yewicore.recuperation.vo.CmmMarquesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMarquesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMarquesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmMarquesService {

    @Autowired
    private CmmMarquesRepository cmmMarquesRepository;

    public Long save(CmmMarquesVO vO) {
        CmmMarques bean = new CmmMarques();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmMarquesRepository.save(bean);
        return bean.getMarId();
    }

    public void delete(Long id) {
        cmmMarquesRepository.deleteById(id);
    }

    public void update(Long id, CmmMarquesUpdateVO vO) {
        CmmMarques bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmMarquesRepository.save(bean);
    }

    public CmmMarquesDTO getById(Long id) {
        CmmMarques original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmMarquesDTO> query(CmmMarquesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmMarquesDTO toDTO(CmmMarques original) {
        CmmMarquesDTO bean = new CmmMarquesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmMarques requireOne(Long id) {
        return cmmMarquesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
