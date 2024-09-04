package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedConsultationOrdo;
import com.yewi.yewicore.recuperation.dtos.MedConsultationOrdoDTO;
import com.yewi.yewicore.recuperation.repository.MedConsultationOrdoRepository;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedConsultationOrdoService {

    @Autowired
    private MedConsultationOrdoRepository medConsultationOrdoRepository;

    public Long save(MedConsultationOrdoVO vO) {
        MedConsultationOrdo bean = new MedConsultationOrdo();
        BeanUtils.copyProperties(vO, bean);
        bean = medConsultationOrdoRepository.save(bean);
        return bean.getCslordId();
    }

    public void delete(Long id) {
        medConsultationOrdoRepository.deleteById(id);
    }

    public void update(Long id, MedConsultationOrdoUpdateVO vO) {
        MedConsultationOrdo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medConsultationOrdoRepository.save(bean);
    }

    public MedConsultationOrdoDTO getById(Long id) {
        MedConsultationOrdo original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedConsultationOrdoDTO> query(MedConsultationOrdoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedConsultationOrdoDTO toDTO(MedConsultationOrdo original) {
        MedConsultationOrdoDTO bean = new MedConsultationOrdoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedConsultationOrdo requireOne(Long id) {
        return medConsultationOrdoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
