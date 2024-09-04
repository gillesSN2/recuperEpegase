package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPatients;
import com.yewi.yewicore.recuperation.dtos.MedPatientsDTO;
import com.yewi.yewicore.recuperation.repository.MedPatientsRepository;
import com.yewi.yewicore.recuperation.vo.MedPatientsQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientsUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPatientsService {

    @Autowired
    private MedPatientsRepository medPatientsRepository;

    public Long save(MedPatientsVO vO) {
        MedPatients bean = new MedPatients();
        BeanUtils.copyProperties(vO, bean);
        bean = medPatientsRepository.save(bean);
        return bean.getPatId();
    }

    public void delete(Long id) {
        medPatientsRepository.deleteById(id);
    }

    public void update(Long id, MedPatientsUpdateVO vO) {
        MedPatients bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPatientsRepository.save(bean);
    }

    public MedPatientsDTO getById(Long id) {
        MedPatients original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPatientsDTO> query(MedPatientsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPatientsDTO toDTO(MedPatients original) {
        MedPatientsDTO bean = new MedPatientsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPatients requireOne(Long id) {
        return medPatientsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
