package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProjet;
import com.yewi.yewicore.recuperation.dtos.CmmProjetDTO;
import com.yewi.yewicore.recuperation.repository.CmmProjetRepository;
import com.yewi.yewicore.recuperation.vo.CmmProjetQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProjetService {

    @Autowired
    private CmmProjetRepository cmmProjetRepository;

    public Long save(CmmProjetVO vO) {
        CmmProjet bean = new CmmProjet();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProjetRepository.save(bean);
        return bean.getProId();
    }

    public void delete(Long id) {
        cmmProjetRepository.deleteById(id);
    }

    public void update(Long id, CmmProjetUpdateVO vO) {
        CmmProjet bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProjetRepository.save(bean);
    }

    public CmmProjetDTO getById(Long id) {
        CmmProjet original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProjetDTO> query(CmmProjetQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProjetDTO toDTO(CmmProjet original) {
        CmmProjetDTO bean = new CmmProjetDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProjet requireOne(Long id) {
        return cmmProjetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
