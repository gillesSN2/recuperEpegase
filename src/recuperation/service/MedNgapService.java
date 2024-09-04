package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedNgap;
import com.yewi.yewicore.recuperation.dtos.MedNgapDTO;
import com.yewi.yewicore.recuperation.repository.MedNgapRepository;
import com.yewi.yewicore.recuperation.vo.MedNgapQueryVO;
import com.yewi.yewicore.recuperation.vo.MedNgapUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedNgapVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedNgapService {

    @Autowired
    private MedNgapRepository medNgapRepository;

    public Long save(MedNgapVO vO) {
        MedNgap bean = new MedNgap();
        BeanUtils.copyProperties(vO, bean);
        bean = medNgapRepository.save(bean);
        return bean.getNgaId();
    }

    public void delete(Long id) {
        medNgapRepository.deleteById(id);
    }

    public void update(Long id, MedNgapUpdateVO vO) {
        MedNgap bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medNgapRepository.save(bean);
    }

    public MedNgapDTO getById(Long id) {
        MedNgap original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedNgapDTO> query(MedNgapQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedNgapDTO toDTO(MedNgap original) {
        MedNgapDTO bean = new MedNgapDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedNgap requireOne(Long id) {
        return medNgapRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
