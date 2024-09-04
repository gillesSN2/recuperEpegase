package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchPump;
import com.yewi.yewicore.recuperation.dtos.AchPumpDTO;
import com.yewi.yewicore.recuperation.repository.AchPumpRepository;
import com.yewi.yewicore.recuperation.vo.AchPumpQueryVO;
import com.yewi.yewicore.recuperation.vo.AchPumpUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchPumpVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchPumpService {

    @Autowired
    private AchPumpRepository achPumpRepository;

    public Long save(AchPumpVO vO) {
        AchPump bean = new AchPump();
        BeanUtils.copyProperties(vO, bean);
        bean = achPumpRepository.save(bean);
        return bean.getPumId();
    }

    public void delete(Long id) {
        achPumpRepository.deleteById(id);
    }

    public void update(Long id, AchPumpUpdateVO vO) {
        AchPump bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achPumpRepository.save(bean);
    }

    public AchPumpDTO getById(Long id) {
        AchPump original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchPumpDTO> query(AchPumpQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchPumpDTO toDTO(AchPump original) {
        AchPumpDTO bean = new AchPumpDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchPump requireOne(Long id) {
        return achPumpRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
