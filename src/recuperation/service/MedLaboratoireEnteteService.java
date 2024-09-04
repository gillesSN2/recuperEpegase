package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedLaboratoireEntete;
import com.yewi.yewicore.recuperation.dtos.MedLaboratoireEnteteDTO;
import com.yewi.yewicore.recuperation.repository.MedLaboratoireEnteteRepository;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedLaboratoireEnteteService {

    @Autowired
    private MedLaboratoireEnteteRepository medLaboratoireEnteteRepository;

    public Long save(MedLaboratoireEnteteVO vO) {
        MedLaboratoireEntete bean = new MedLaboratoireEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = medLaboratoireEnteteRepository.save(bean);
        return bean.getLabId();
    }

    public void delete(Long id) {
        medLaboratoireEnteteRepository.deleteById(id);
    }

    public void update(Long id, MedLaboratoireEnteteUpdateVO vO) {
        MedLaboratoireEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medLaboratoireEnteteRepository.save(bean);
    }

    public MedLaboratoireEnteteDTO getById(Long id) {
        MedLaboratoireEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedLaboratoireEnteteDTO> query(MedLaboratoireEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedLaboratoireEnteteDTO toDTO(MedLaboratoireEntete original) {
        MedLaboratoireEnteteDTO bean = new MedLaboratoireEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedLaboratoireEntete requireOne(Long id) {
        return medLaboratoireEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
