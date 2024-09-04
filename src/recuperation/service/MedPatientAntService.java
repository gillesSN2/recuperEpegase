package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPatientAnt;
import com.yewi.yewicore.recuperation.dtos.MedPatientAntDTO;
import com.yewi.yewicore.recuperation.repository.MedPatientAntRepository;
import com.yewi.yewicore.recuperation.vo.MedPatientAntQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientAntUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientAntVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPatientAntService {

    @Autowired
    private MedPatientAntRepository medPatientAntRepository;

    public Long save(MedPatientAntVO vO) {
        MedPatientAnt bean = new MedPatientAnt();
        BeanUtils.copyProperties(vO, bean);
        bean = medPatientAntRepository.save(bean);
        return bean.getPatantId();
    }

    public void delete(Long id) {
        medPatientAntRepository.deleteById(id);
    }

    public void update(Long id, MedPatientAntUpdateVO vO) {
        MedPatientAnt bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPatientAntRepository.save(bean);
    }

    public MedPatientAntDTO getById(Long id) {
        MedPatientAnt original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPatientAntDTO> query(MedPatientAntQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPatientAntDTO toDTO(MedPatientAnt original) {
        MedPatientAntDTO bean = new MedPatientAntDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPatientAnt requireOne(Long id) {
        return medPatientAntRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
