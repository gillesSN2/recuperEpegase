package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationActes;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationActesDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationActesRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationActesService {

    @Autowired
    private MedHospitalisationActesRepository medHospitalisationActesRepository;

    public Long save(MedHospitalisationActesVO vO) {
        MedHospitalisationActes bean = new MedHospitalisationActes();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationActesRepository.save(bean);
        return bean.getHosactId();
    }

    public void delete(Long id) {
        medHospitalisationActesRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationActesUpdateVO vO) {
        MedHospitalisationActes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationActesRepository.save(bean);
    }

    public MedHospitalisationActesDTO getById(Long id) {
        MedHospitalisationActes original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationActesDTO> query(MedHospitalisationActesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationActesDTO toDTO(MedHospitalisationActes original) {
        MedHospitalisationActesDTO bean = new MedHospitalisationActesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationActes requireOne(Long id) {
        return medHospitalisationActesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
