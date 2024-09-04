package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptExercicesComptable;
import com.yewi.yewicore.recuperation.dtos.CptExercicesComptableDTO;
import com.yewi.yewicore.recuperation.repository.CptExercicesComptableRepository;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableQueryVO;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptExercicesComptableService {

    @Autowired
    private CptExercicesComptableRepository cptExercicesComptableRepository;

    public Long save(CptExercicesComptableVO vO) {
        CptExercicesComptable bean = new CptExercicesComptable();
        BeanUtils.copyProperties(vO, bean);
        bean = cptExercicesComptableRepository.save(bean);
        return bean.getExecptId();
    }

    public void delete(Long id) {
        cptExercicesComptableRepository.deleteById(id);
    }

    public void update(Long id, CptExercicesComptableUpdateVO vO) {
        CptExercicesComptable bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptExercicesComptableRepository.save(bean);
    }

    public CptExercicesComptableDTO getById(Long id) {
        CptExercicesComptable original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptExercicesComptableDTO> query(CptExercicesComptableQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptExercicesComptableDTO toDTO(CptExercicesComptable original) {
        CptExercicesComptableDTO bean = new CptExercicesComptableDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptExercicesComptable requireOne(Long id) {
        return cptExercicesComptableRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
