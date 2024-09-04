package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationLabo;
import com.yewi.yewicore.recuperation.dtos.MedHospitalisationLaboDTO;
import com.yewi.yewicore.recuperation.repository.MedHospitalisationLaboRepository;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedHospitalisationLaboService {

    @Autowired
    private MedHospitalisationLaboRepository medHospitalisationLaboRepository;

    public Long save(MedHospitalisationLaboVO vO) {
        MedHospitalisationLabo bean = new MedHospitalisationLabo();
        BeanUtils.copyProperties(vO, bean);
        bean = medHospitalisationLaboRepository.save(bean);
        return bean.getHoslabId();
    }

    public void delete(Long id) {
        medHospitalisationLaboRepository.deleteById(id);
    }

    public void update(Long id, MedHospitalisationLaboUpdateVO vO) {
        MedHospitalisationLabo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medHospitalisationLaboRepository.save(bean);
    }

    public MedHospitalisationLaboDTO getById(Long id) {
        MedHospitalisationLabo original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedHospitalisationLaboDTO> query(MedHospitalisationLaboQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedHospitalisationLaboDTO toDTO(MedHospitalisationLabo original) {
        MedHospitalisationLaboDTO bean = new MedHospitalisationLaboDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedHospitalisationLabo requireOne(Long id) {
        return medHospitalisationLaboRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
