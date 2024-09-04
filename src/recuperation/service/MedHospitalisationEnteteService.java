package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationEntete;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationEnteteDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationEnteteRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationEnteteService {

    @Autowired
    private MedHospitalisationEnteteRepository medHospitalisationEnteteRepository;

    public Long save(MedHospitalisationEnteteVO vO) {
        MedHospitalisationEntete bean = new MedHospitalisationEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationEnteteRepository.save(bean);
        return bean.getHosId();
    }

    public void delete(Long id) {
        medHospitalisationEnteteRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationEnteteUpdateVO vO) {
        MedHospitalisationEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationEnteteRepository.save(bean);
    }

    public MedHospitalisationEnteteDTO getById(Long id) {
        MedHospitalisationEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationEnteteDTO> query(MedHospitalisationEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationEnteteDTO toDTO(MedHospitalisationEntete original) {
        MedHospitalisationEnteteDTO bean = new MedHospitalisationEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationEntete requireOne(Long id) {
        return medHospitalisationEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
