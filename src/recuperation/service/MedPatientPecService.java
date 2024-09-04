package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPatientPec;
import com.yewi.yewicore.recuperation.dtos.MedPatientPecDTO;
import com.yewi.yewicore.recuperation.repository.MedPatientPecRepository;
import com.yewi.yewicore.recuperation.vo.MedPatientPecQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientPecUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientPecVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPatientPecService {

    @Autowired
    private MedPatientPecRepository medPatientPecRepository;

    public Long save(MedPatientPecVO vO) {
        MedPatientPec bean = new MedPatientPec();
        BeanUtils.copyProperties(vO, bean);
        bean = medPatientPecRepository.save(bean);
        return bean.getPatpecId();
    }

    public void delete(Long id) {
        medPatientPecRepository.deleteById(id);
    }

    public void update(Long id, MedPatientPecUpdateVO vO) {
        MedPatientPec bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPatientPecRepository.save(bean);
    }

    public MedPatientPecDTO getById(Long id) {
        MedPatientPec original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPatientPecDTO> query(MedPatientPecQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPatientPecDTO toDTO(MedPatientPec original) {
        MedPatientPecDTO bean = new MedPatientPecDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPatientPec requireOne(Long id) {
        return medPatientPecRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
