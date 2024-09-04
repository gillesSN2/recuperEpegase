package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedCim;
import com.yewi.yewicore.recuperation.dtos.MedCimDTO;
import com.yewi.yewicore.recuperation.repository.MedCimRepository;
import com.yewi.yewicore.recuperation.vo.MedCimQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCimUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCimVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedCimService {

    @Autowired
    private MedCimRepository medCimRepository;

    public Long save(MedCimVO vO) {
        MedCim bean = new MedCim();
        BeanUtils.copyProperties(vO, bean);
        bean = medCimRepository.save(bean);
        return bean.getCimId();
    }

    public void delete(Long id) {
        medCimRepository.deleteById(id);
    }

    public void update(Long id, MedCimUpdateVO vO) {
        MedCim bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medCimRepository.save(bean);
    }

    public MedCimDTO getById(Long id) {
        MedCim original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedCimDTO> query(MedCimQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedCimDTO toDTO(MedCim original) {
        MedCimDTO bean = new MedCimDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedCim requireOne(Long id) {
        return medCimRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
