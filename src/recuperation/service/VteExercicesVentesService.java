package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteExercicesVentes;
import com.yewi.yewicore.recuperation.dtos.VteExercicesVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteExercicesVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteExercicesVentesService {

    @Autowired
    private VteExercicesVentesRepository vteExercicesVentesRepository;

    public Long save(VteExercicesVentesVO vO) {
        VteExercicesVentes bean = new VteExercicesVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteExercicesVentesRepository.save(bean);
        return bean.getExevteId();
    }

    public void delete(Long id) {
        vteExercicesVentesRepository.deleteById(id);
    }

    public void update(Long id, VteExercicesVentesUpdateVO vO) {
        VteExercicesVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteExercicesVentesRepository.save(bean);
    }

    public VteExercicesVentesDTO getById(Long id) {
        VteExercicesVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteExercicesVentesDTO> query(VteExercicesVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteExercicesVentesDTO toDTO(VteExercicesVentes original) {
        VteExercicesVentesDTO bean = new VteExercicesVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteExercicesVentes requireOne(Long id) {
        return vteExercicesVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
