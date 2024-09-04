package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationSejour;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationSejourDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationSejourRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationSejourService {

    @Autowired
    private MedHospitalisationSejourRepository medHospitalisationSejourRepository;

    public Long save(MedHospitalisationSejourVO vO) {
        MedHospitalisationSejour bean = new MedHospitalisationSejour();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationSejourRepository.save(bean);
        return bean.getHossejId();
    }

    public void delete(Long id) {
        medHospitalisationSejourRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationSejourUpdateVO vO) {
        MedHospitalisationSejour bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationSejourRepository.save(bean);
    }

    public MedHospitalisationSejourDTO getById(Long id) {
        MedHospitalisationSejour original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationSejourDTO> query(MedHospitalisationSejourQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationSejourDTO toDTO(MedHospitalisationSejour original) {
        MedHospitalisationSejourDTO bean = new MedHospitalisationSejourDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationSejour requireOne(Long id) {
        return medHospitalisationSejourRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
