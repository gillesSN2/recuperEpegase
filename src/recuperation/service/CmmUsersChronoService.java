package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUsersChrono;
import com.yewi.yewicore.recuperation.dtos.CmmUsersChronoDTO;
import com.yewi.yewicore.recuperation.repository.CmmUsersChronoRepository;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUsersChronoService {

    @Autowired
    private CmmUsersChronoRepository cmmUsersChronoRepository;

    public Long save(CmmUsersChronoVO vO) {
        CmmUsersChrono bean = new CmmUsersChrono();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUsersChronoRepository.save(bean);
        return bean.getUsrchrId();
    }

    public void delete(Long id) {
        cmmUsersChronoRepository.deleteById(id);
    }

    public void update(Long id, CmmUsersChronoUpdateVO vO) {
        CmmUsersChrono bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUsersChronoRepository.save(bean);
    }

    public CmmUsersChronoDTO getById(Long id) {
        CmmUsersChrono original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUsersChronoDTO> query(CmmUsersChronoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUsersChronoDTO toDTO(CmmUsersChrono original) {
        CmmUsersChronoDTO bean = new CmmUsersChronoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUsersChrono requireOne(Long id) {
        return cmmUsersChronoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
