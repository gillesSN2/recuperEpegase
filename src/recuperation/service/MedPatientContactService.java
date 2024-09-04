package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPatientContact;
import com.yewi.yewicore.recuperation.dtos.MedPatientContactDTO;
import com.yewi.yewicore.recuperation.repository.MedPatientContactRepository;
import com.yewi.yewicore.recuperation.vo.MedPatientContactQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientContactUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientContactVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPatientContactService {

    @Autowired
    private MedPatientContactRepository medPatientContactRepository;

    public Long save(MedPatientContactVO vO) {
        MedPatientContact bean = new MedPatientContact();
        BeanUtils.copyProperties(vO, bean);
        bean = medPatientContactRepository.save(bean);
        return bean.getPatconId();
    }

    public void delete(Long id) {
        medPatientContactRepository.deleteById(id);
    }

    public void update(Long id, MedPatientContactUpdateVO vO) {
        MedPatientContact bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPatientContactRepository.save(bean);
    }

    public MedPatientContactDTO getById(Long id) {
        MedPatientContact original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPatientContactDTO> query(MedPatientContactQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPatientContactDTO toDTO(MedPatientContact original) {
        MedPatientContactDTO bean = new MedPatientContactDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPatientContact requireOne(Long id) {
        return medPatientContactRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
