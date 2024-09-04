package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProjetRubrique;
import com.yewi.yewicore.recuperation.dtos.CmmProjetRubriqueDTO;
import com.yewi.yewicore.recuperation.repository.CmmProjetRubriqueRepository;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProjetRubriqueService {

    @Autowired
    private CmmProjetRubriqueRepository cmmProjetRubriqueRepository;

    public Long save(CmmProjetRubriqueVO vO) {
        CmmProjetRubrique bean = new CmmProjetRubrique();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProjetRubriqueRepository.save(bean);
        return bean.getProrubId();
    }

    public void delete(Long id) {
        cmmProjetRubriqueRepository.deleteById(id);
    }

    public void update(Long id, CmmProjetRubriqueUpdateVO vO) {
        CmmProjetRubrique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProjetRubriqueRepository.save(bean);
    }

    public CmmProjetRubriqueDTO getById(Long id) {
        CmmProjetRubrique original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProjetRubriqueDTO> query(CmmProjetRubriqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProjetRubriqueDTO toDTO(CmmProjetRubrique original) {
        CmmProjetRubriqueDTO bean = new CmmProjetRubriqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProjetRubrique requireOne(Long id) {
        return cmmProjetRubriqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
