package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedConsultationEnteteGene;
import com.yewi.yewicore.recuperation.dtos.MedConsultationEnteteGeneDTO;
import com.yewi.yewicore.recuperation.repository.MedConsultationEnteteGeneRepository;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedConsultationEnteteGeneService {

    @Autowired
    private MedConsultationEnteteGeneRepository medConsultationEnteteGeneRepository;

    public Long save(MedConsultationEnteteGeneVO vO) {
        MedConsultationEnteteGene bean = new MedConsultationEnteteGene();
        BeanUtils.copyProperties(vO, bean);
        bean = medConsultationEnteteGeneRepository.save(bean);
        return bean.getCsgId();
    }

    public void delete(Long id) {
        medConsultationEnteteGeneRepository.deleteById(id);
    }

    public void update(Long id, MedConsultationEnteteGeneUpdateVO vO) {
        MedConsultationEnteteGene bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medConsultationEnteteGeneRepository.save(bean);
    }

    public MedConsultationEnteteGeneDTO getById(Long id) {
        MedConsultationEnteteGene original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedConsultationEnteteGeneDTO> query(MedConsultationEnteteGeneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedConsultationEnteteGeneDTO toDTO(MedConsultationEnteteGene original) {
        MedConsultationEnteteGeneDTO bean = new MedConsultationEnteteGeneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedConsultationEnteteGene requireOne(Long id) {
        return medConsultationEnteteGeneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
