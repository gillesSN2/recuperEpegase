package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedConventionMedical;
import com.yewi.yewicore.recuperation.dtos.MedConventionMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedConventionMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedConventionMedicalService {

    @Autowired
    private MedConventionMedicalRepository medConventionMedicalRepository;

    public Long save(MedConventionMedicalVO vO) {
        MedConventionMedical bean = new MedConventionMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medConventionMedicalRepository.save(bean);
        return bean.getCvnId();
    }

    public void delete(Long id) {
        medConventionMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedConventionMedicalUpdateVO vO) {
        MedConventionMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medConventionMedicalRepository.save(bean);
    }

    public MedConventionMedicalDTO getById(Long id) {
        MedConventionMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedConventionMedicalDTO> query(MedConventionMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedConventionMedicalDTO toDTO(MedConventionMedical original) {
        MedConventionMedicalDTO bean = new MedConventionMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedConventionMedical requireOne(Long id) {
        return medConventionMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
