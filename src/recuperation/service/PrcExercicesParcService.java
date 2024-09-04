package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcExercicesParc;
import com.yewi.yewicore.recuperation.dtos.PrcExercicesParcDTO;
import com.yewi.yewicore.recuperation.repository.PrcExercicesParcRepository;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcExercicesParcService {

    @Autowired
    private PrcExercicesParcRepository prcExercicesParcRepository;

    public Long save(PrcExercicesParcVO vO) {
        PrcExercicesParc bean = new PrcExercicesParc();
        BeanUtils.copyProperties(vO, bean);
        bean = prcExercicesParcRepository.save(bean);
        return bean.getExeprcId();
    }

    public void delete(Long id) {
        prcExercicesParcRepository.deleteById(id);
    }

    public void update(Long id, PrcExercicesParcUpdateVO vO) {
        PrcExercicesParc bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcExercicesParcRepository.save(bean);
    }

    public PrcExercicesParcDTO getById(Long id) {
        PrcExercicesParc original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcExercicesParcDTO> query(PrcExercicesParcQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcExercicesParcDTO toDTO(PrcExercicesParc original) {
        PrcExercicesParcDTO bean = new PrcExercicesParcDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcExercicesParc requireOne(Long id) {
        return prcExercicesParcRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
