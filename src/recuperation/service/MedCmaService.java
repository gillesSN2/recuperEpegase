package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedCma;
import com.yewi.yewicore.recuperation.dtos.MedCmaDTO;
import com.yewi.yewicore.recuperation.repository.MedCmaRepository;
import com.yewi.yewicore.recuperation.vo.MedCmaQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCmaUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCmaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedCmaService {

    @Autowired
    private MedCmaRepository medCmaRepository;

    public Long save(MedCmaVO vO) {
        MedCma bean = new MedCma();
        BeanUtils.copyProperties(vO, bean);
        bean = medCmaRepository.save(bean);
        return bean.getCmaId();
    }

    public void delete(Long id) {
        medCmaRepository.deleteById(id);
    }

    public void update(Long id, MedCmaUpdateVO vO) {
        MedCma bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medCmaRepository.save(bean);
    }

    public MedCmaDTO getById(Long id) {
        MedCma original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedCmaDTO> query(MedCmaQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedCmaDTO toDTO(MedCma original) {
        MedCmaDTO bean = new MedCmaDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedCma requireOne(Long id) {
        return medCmaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
