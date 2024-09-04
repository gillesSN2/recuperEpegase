package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedSpecialitesMedical;
import com.yewi.yewicore.recuperation.dtos.MedSpecialitesMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedSpecialitesMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedSpecialitesMedicalService {

    @Autowired
    private MedSpecialitesMedicalRepository medSpecialitesMedicalRepository;

    public Long save(MedSpecialitesMedicalVO vO) {
        MedSpecialitesMedical bean = new MedSpecialitesMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medSpecialitesMedicalRepository.save(bean);
        return bean.getSpemedId();
    }

    public void delete(Long id) {
        medSpecialitesMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedSpecialitesMedicalUpdateVO vO) {
        MedSpecialitesMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medSpecialitesMedicalRepository.save(bean);
    }

    public MedSpecialitesMedicalDTO getById(Long id) {
        MedSpecialitesMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedSpecialitesMedicalDTO> query(MedSpecialitesMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedSpecialitesMedicalDTO toDTO(MedSpecialitesMedical original) {
        MedSpecialitesMedicalDTO bean = new MedSpecialitesMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedSpecialitesMedical requireOne(Long id) {
        return medSpecialitesMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
