package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmTaches;
import com.yewi.yewicore.recuperation.dtos.CmmTachesDTO;
import com.yewi.yewicore.recuperation.repository.CmmTachesRepository;
import com.yewi.yewicore.recuperation.vo.CmmTachesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTachesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTachesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmTachesService {

    @Autowired
    private CmmTachesRepository cmmTachesRepository;

    public Long save(CmmTachesVO vO) {
        CmmTaches bean = new CmmTaches();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmTachesRepository.save(bean);
        return bean.getTacId();
    }

    public void delete(Long id) {
        cmmTachesRepository.deleteById(id);
    }

    public void update(Long id, CmmTachesUpdateVO vO) {
        CmmTaches bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmTachesRepository.save(bean);
    }

    public CmmTachesDTO getById(Long id) {
        CmmTaches original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmTachesDTO> query(CmmTachesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmTachesDTO toDTO(CmmTaches original) {
        CmmTachesDTO bean = new CmmTachesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmTaches requireOne(Long id) {
        return cmmTachesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
