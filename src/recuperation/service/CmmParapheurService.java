package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmParapheur;
import com.yewi.yewicore.recuperation.dtos.CmmParapheurDTO;
import com.yewi.yewicore.recuperation.repository.CmmParapheurRepository;
import com.yewi.yewicore.recuperation.vo.CmmParapheurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmParapheurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmParapheurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmParapheurService {

    @Autowired
    private CmmParapheurRepository cmmParapheurRepository;

    public Long save(CmmParapheurVO vO) {
        CmmParapheur bean = new CmmParapheur();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmParapheurRepository.save(bean);
        return bean.getPhrId();
    }

    public void delete(Long id) {
        cmmParapheurRepository.deleteById(id);
    }

    public void update(Long id, CmmParapheurUpdateVO vO) {
        CmmParapheur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmParapheurRepository.save(bean);
    }

    public CmmParapheurDTO getById(Long id) {
        CmmParapheur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmParapheurDTO> query(CmmParapheurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmParapheurDTO toDTO(CmmParapheur original) {
        CmmParapheurDTO bean = new CmmParapheurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmParapheur requireOne(Long id) {
        return cmmParapheurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
