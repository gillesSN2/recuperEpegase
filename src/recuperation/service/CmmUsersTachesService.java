package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUsersTaches;
import com.yewi.yewicore.recuperation.dtos.CmmUsersTachesDTO;
import com.yewi.yewicore.recuperation.repository.CmmUsersTachesRepository;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUsersTachesService {

    @Autowired
    private CmmUsersTachesRepository cmmUsersTachesRepository;

    public Long save(CmmUsersTachesVO vO) {
        CmmUsersTaches bean = new CmmUsersTaches();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUsersTachesRepository.save(bean);
        return bean.getUsrtacId();
    }

    public void delete(Long id) {
        cmmUsersTachesRepository.deleteById(id);
    }

    public void update(Long id, CmmUsersTachesUpdateVO vO) {
        CmmUsersTaches bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUsersTachesRepository.save(bean);
    }

    public CmmUsersTachesDTO getById(Long id) {
        CmmUsersTaches original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUsersTachesDTO> query(CmmUsersTachesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUsersTachesDTO toDTO(CmmUsersTaches original) {
        CmmUsersTachesDTO bean = new CmmUsersTachesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUsersTaches requireOne(Long id) {
        return cmmUsersTachesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
