package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedConsultationActes;
import com.yewi.yewicore.recuperation.dtos.MedConsultationActesDTO;
import com.yewi.yewicore.recuperation.repository.MedConsultationActesRepository;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedConsultationActesService {

    @Autowired
    private MedConsultationActesRepository medConsultationActesRepository;

    public Long save(MedConsultationActesVO vO) {
        MedConsultationActes bean = new MedConsultationActes();
        BeanUtils.copyProperties(vO, bean);
        bean = medConsultationActesRepository.save(bean);
        return bean.getCslactId();
    }

    public void delete(Long id) {
        medConsultationActesRepository.deleteById(id);
    }

    public void update(Long id, MedConsultationActesUpdateVO vO) {
        MedConsultationActes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medConsultationActesRepository.save(bean);
    }

    public MedConsultationActesDTO getById(Long id) {
        MedConsultationActes original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedConsultationActesDTO> query(MedConsultationActesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedConsultationActesDTO toDTO(MedConsultationActes original) {
        MedConsultationActesDTO bean = new MedConsultationActesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedConsultationActes requireOne(Long id) {
        return medConsultationActesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
