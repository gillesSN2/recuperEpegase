package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedExercicesMedical;
import com.yewi.yewicore.recuperation.dtos.MedExercicesMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedExercicesMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedExercicesMedicalService {

    @Autowired
    private MedExercicesMedicalRepository medExercicesMedicalRepository;

    public Long save(MedExercicesMedicalVO vO) {
        MedExercicesMedical bean = new MedExercicesMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medExercicesMedicalRepository.save(bean);
        return bean.getExemedId();
    }

    public void delete(Long id) {
        medExercicesMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedExercicesMedicalUpdateVO vO) {
        MedExercicesMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medExercicesMedicalRepository.save(bean);
    }

    public MedExercicesMedicalDTO getById(Long id) {
        MedExercicesMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedExercicesMedicalDTO> query(MedExercicesMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedExercicesMedicalDTO toDTO(MedExercicesMedical original) {
        MedExercicesMedicalDTO bean = new MedExercicesMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedExercicesMedical requireOne(Long id) {
        return medExercicesMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
