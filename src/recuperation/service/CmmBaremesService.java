package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmBaremes;
import com.yewi.yewicore.recuperation.dtos.CmmBaremesDTO;
import com.yewi.yewicore.recuperation.repository.CmmBaremesRepository;
import com.yewi.yewicore.recuperation.vo.CmmBaremesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmBaremesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmBaremesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmBaremesService {

    @Autowired
    private CmmBaremesRepository cmmBaremesRepository;

    public Long save(CmmBaremesVO vO) {
        CmmBaremes bean = new CmmBaremes();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmBaremesRepository.save(bean);
        return bean.getBarId();
    }

    public void delete(Long id) {
        cmmBaremesRepository.deleteById(id);
    }

    public void update(Long id, CmmBaremesUpdateVO vO) {
        CmmBaremes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmBaremesRepository.save(bean);
    }

    public CmmBaremesDTO getById(Long id) {
        CmmBaremes original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmBaremesDTO> query(CmmBaremesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmBaremesDTO toDTO(CmmBaremes original) {
        CmmBaremesDTO bean = new CmmBaremesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmBaremes requireOne(Long id) {
        return cmmBaremesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
