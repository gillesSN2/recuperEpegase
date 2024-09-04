package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationPrest;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationPrestDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationPrestRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationPrestService {

    @Autowired
    private MedHospitalisationPrestRepository medHospitalisationPrestRepository;

    public Long save(MedHospitalisationPrestVO vO) {
        MedHospitalisationPrest bean = new MedHospitalisationPrest();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationPrestRepository.save(bean);
        return bean.getHosprtId();
    }

    public void delete(Long id) {
        medHospitalisationPrestRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationPrestUpdateVO vO) {
        MedHospitalisationPrest bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationPrestRepository.save(bean);
    }

    public MedHospitalisationPrestDTO getById(Long id) {
        MedHospitalisationPrest original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationPrestDTO> query(MedHospitalisationPrestQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationPrestDTO toDTO(MedHospitalisationPrest original) {
        MedHospitalisationPrestDTO bean = new MedHospitalisationPrestDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationPrest requireOne(Long id) {
        return medHospitalisationPrestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
