package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmRdv;
import com.yewi.yewicore.recuperation.dtos.CmmRdvDTO;
import com.yewi.yewicore.recuperation.repository.CmmRdvRepository;
import com.yewi.yewicore.recuperation.vo.CmmRdvQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmRdvUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmRdvVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmRdvService {

    @Autowired
    private CmmRdvRepository cmmRdvRepository;

    public Long save(CmmRdvVO vO) {
        CmmRdv bean = new CmmRdv();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmRdvRepository.save(bean);
        return bean.getRdvId();
    }

    public void delete(Long id) {
        cmmRdvRepository.deleteById(id);
    }

    public void update(Long id, CmmRdvUpdateVO vO) {
        CmmRdv bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmRdvRepository.save(bean);
    }

    public CmmRdvDTO getById(Long id) {
        CmmRdv original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmRdvDTO> query(CmmRdvQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmRdvDTO toDTO(CmmRdv original) {
        CmmRdvDTO bean = new CmmRdvDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmRdv requireOne(Long id) {
        return cmmRdvRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
