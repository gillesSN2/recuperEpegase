package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCessionEntete;
import com.yewi.yewicore.recuperation.dtos.AchCessionEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchCessionEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCessionEnteteService {

    @Autowired
    private AchCessionEnteteRepository achCessionEnteteRepository;

    public Long save(AchCessionEnteteVO vO) {
        AchCessionEntete bean = new AchCessionEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achCessionEnteteRepository.save(bean);
        return bean.getCesId();
    }

    public void delete(Long id) {
        achCessionEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchCessionEnteteUpdateVO vO) {
        AchCessionEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCessionEnteteRepository.save(bean);
    }

    public AchCessionEnteteDTO getById(Long id) {
        AchCessionEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCessionEnteteDTO> query(AchCessionEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCessionEnteteDTO toDTO(AchCessionEntete original) {
        AchCessionEnteteDTO bean = new AchCessionEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCessionEntete requireOne(Long id) {
        return achCessionEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
