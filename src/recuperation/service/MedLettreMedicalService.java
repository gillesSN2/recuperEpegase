package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedLettreMedical;
import com.yewi.yewicore.recuperation.dtos.MedLettreMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedLettreMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedLettreMedicalService {

    @Autowired
    private MedLettreMedicalRepository medLettreMedicalRepository;

    public Long save(MedLettreMedicalVO vO) {
        MedLettreMedical bean = new MedLettreMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medLettreMedicalRepository.save(bean);
        return bean.getLetId();
    }

    public void delete(Long id) {
        medLettreMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedLettreMedicalUpdateVO vO) {
        MedLettreMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medLettreMedicalRepository.save(bean);
    }

    public MedLettreMedicalDTO getById(Long id) {
        MedLettreMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedLettreMedicalDTO> query(MedLettreMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedLettreMedicalDTO toDTO(MedLettreMedical original) {
        MedLettreMedicalDTO bean = new MedLettreMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedLettreMedical requireOne(Long id) {
        return medLettreMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
