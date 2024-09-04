package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationMedi;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationMediDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationMediRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationMediService {

    @Autowired
    private MedHospitalisationMediRepository medHospitalisationMediRepository;

    public Long save(MedHospitalisationMediVO vO) {
        MedHospitalisationMedi bean = new MedHospitalisationMedi();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationMediRepository.save(bean);
        return bean.getHosmedId();
    }

    public void delete(Long id) {
        medHospitalisationMediRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationMediUpdateVO vO) {
        MedHospitalisationMedi bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationMediRepository.save(bean);
    }

    public MedHospitalisationMediDTO getById(Long id) {
        MedHospitalisationMedi original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationMediDTO> query(MedHospitalisationMediQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationMediDTO toDTO(MedHospitalisationMedi original) {
        MedHospitalisationMediDTO bean = new MedHospitalisationMediDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationMedi requireOne(Long id) {
        return medHospitalisationMediRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
