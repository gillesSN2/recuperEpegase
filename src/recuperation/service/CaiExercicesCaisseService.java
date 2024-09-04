package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiExercicesCaisse;
import com.yewi.yewicore.recuperation.dtos.CaiExercicesCaisseDTO;
import com.yewi.yewicore.recuperation.repository.CaiExercicesCaisseRepository;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiExercicesCaisseService {

    @Autowired
    private CaiExercicesCaisseRepository caiExercicesCaisseRepository;

    public Long save(CaiExercicesCaisseVO vO) {
        CaiExercicesCaisse bean = new CaiExercicesCaisse();
        BeanUtils.copyProperties(vO, bean);
        bean = caiExercicesCaisseRepository.save(bean);
        return bean.getExecaiId();
    }

    public void delete(Long id) {
        caiExercicesCaisseRepository.deleteById(id);
    }

    public void update(Long id, CaiExercicesCaisseUpdateVO vO) {
        CaiExercicesCaisse bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiExercicesCaisseRepository.save(bean);
    }

    public CaiExercicesCaisseDTO getById(Long id) {
        CaiExercicesCaisse original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiExercicesCaisseDTO> query(CaiExercicesCaisseQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiExercicesCaisseDTO toDTO(CaiExercicesCaisse original) {
        CaiExercicesCaisseDTO bean = new CaiExercicesCaisseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiExercicesCaisse requireOne(Long id) {
        return caiExercicesCaisseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
