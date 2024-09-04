package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFraisEntete;
import com.yewi.yewicore.recuperation.dtos.AchFraisEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchFraisEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFraisEnteteService {

    @Autowired
    private AchFraisEnteteRepository achFraisEnteteRepository;

    public Long save(AchFraisEnteteVO vO) {
        AchFraisEntete bean = new AchFraisEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achFraisEnteteRepository.save(bean);
        return bean.getFsfId();
    }

    public void delete(Long id) {
        achFraisEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchFraisEnteteUpdateVO vO) {
        AchFraisEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFraisEnteteRepository.save(bean);
    }

    public AchFraisEnteteDTO getById(Long id) {
        AchFraisEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFraisEnteteDTO> query(AchFraisEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFraisEnteteDTO toDTO(AchFraisEntete original) {
        AchFraisEnteteDTO bean = new AchFraisEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFraisEntete requireOne(Long id) {
        return achFraisEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
