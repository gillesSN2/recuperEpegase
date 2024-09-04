package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedCcam;
import com.yewi.yewicore.recuperation.dtos.MedCcamDTO;
import com.yewi.yewicore.recuperation.repository.MedCcamRepository;
import com.yewi.yewicore.recuperation.vo.MedCcamQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCcamUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCcamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedCcamService {

    @Autowired
    private MedCcamRepository medCcamRepository;

    public Long save(MedCcamVO vO) {
        MedCcam bean = new MedCcam();
        BeanUtils.copyProperties(vO, bean);
        bean = medCcamRepository.save(bean);
        return bean.getCcamId();
    }

    public void delete(Long id) {
        medCcamRepository.deleteById(id);
    }

    public void update(Long id, MedCcamUpdateVO vO) {
        MedCcam bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medCcamRepository.save(bean);
    }

    public MedCcamDTO getById(Long id) {
        MedCcam original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedCcamDTO> query(MedCcamQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedCcamDTO toDTO(MedCcam original) {
        MedCcamDTO bean = new MedCcamDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedCcam requireOne(Long id) {
        return medCcamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
