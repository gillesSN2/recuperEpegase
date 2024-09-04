package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedConsultationLabo;
import com.yewi.yewicore.recuperation.dtos.MedConsultationLaboDTO;
import com.yewi.yewicore.recuperation.repository.MedConsultationLaboRepository;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedConsultationLaboService {

    @Autowired
    private MedConsultationLaboRepository medConsultationLaboRepository;

    public Long save(MedConsultationLaboVO vO) {
        MedConsultationLabo bean = new MedConsultationLabo();
        BeanUtils.copyProperties(vO, bean);
        bean = medConsultationLaboRepository.save(bean);
        return bean.getCsllabId();
    }

    public void delete(Long id) {
        medConsultationLaboRepository.deleteById(id);
    }

    public void update(Long id, MedConsultationLaboUpdateVO vO) {
        MedConsultationLabo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medConsultationLaboRepository.save(bean);
    }

    public MedConsultationLaboDTO getById(Long id) {
        MedConsultationLabo original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedConsultationLaboDTO> query(MedConsultationLaboQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedConsultationLaboDTO toDTO(MedConsultationLabo original) {
        MedConsultationLaboDTO bean = new MedConsultationLaboDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedConsultationLabo requireOne(Long id) {
        return medConsultationLaboRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
