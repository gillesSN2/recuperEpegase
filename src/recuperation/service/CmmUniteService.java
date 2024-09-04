package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUnite;
import com.yewi.yewicore.recuperation.dtos.CmmUniteDTO;
import com.yewi.yewicore.recuperation.repository.CmmUniteRepository;
import com.yewi.yewicore.recuperation.vo.CmmUniteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUniteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUniteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUniteService {

    @Autowired
    private CmmUniteRepository cmmUniteRepository;

    public Long save(CmmUniteVO vO) {
        CmmUnite bean = new CmmUnite();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUniteRepository.save(bean);
        return bean.getUniId();
    }

    public void delete(Long id) {
        cmmUniteRepository.deleteById(id);
    }

    public void update(Long id, CmmUniteUpdateVO vO) {
        CmmUnite bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUniteRepository.save(bean);
    }

    public CmmUniteDTO getById(Long id) {
        CmmUnite original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUniteDTO> query(CmmUniteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUniteDTO toDTO(CmmUnite original) {
        CmmUniteDTO bean = new CmmUniteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUnite requireOne(Long id) {
        return cmmUniteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
