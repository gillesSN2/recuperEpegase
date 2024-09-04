package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPatientProt;
import com.yewi.yewicore.recuperation.dtos.MedPatientProtDTO;
import com.yewi.yewicore.recuperation.repository.MedPatientProtRepository;
import com.yewi.yewicore.recuperation.vo.MedPatientProtQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientProtUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientProtVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPatientProtService {

    @Autowired
    private MedPatientProtRepository medPatientProtRepository;

    public Long save(MedPatientProtVO vO) {
        MedPatientProt bean = new MedPatientProt();
        BeanUtils.copyProperties(vO, bean);
        bean = medPatientProtRepository.save(bean);
        return bean.getPatprtId();
    }

    public void delete(Long id) {
        medPatientProtRepository.deleteById(id);
    }

    public void update(Long id, MedPatientProtUpdateVO vO) {
        MedPatientProt bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPatientProtRepository.save(bean);
    }

    public MedPatientProtDTO getById(Long id) {
        MedPatientProt original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPatientProtDTO> query(MedPatientProtQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPatientProtDTO toDTO(MedPatientProt original) {
        MedPatientProtDTO bean = new MedPatientProtDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPatientProt requireOne(Long id) {
        return medPatientProtRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
