package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchSommierEntete;
import com.yewi.yewicore.recuperation.dtos.AchSommierEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchSommierEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchSommierEnteteService {

    @Autowired
    private AchSommierEnteteRepository achSommierEnteteRepository;

    public Long save(AchSommierEnteteVO vO) {
        AchSommierEntete bean = new AchSommierEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achSommierEnteteRepository.save(bean);
        return bean.getSomId();
    }

    public void delete(Long id) {
        achSommierEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchSommierEnteteUpdateVO vO) {
        AchSommierEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achSommierEnteteRepository.save(bean);
    }

    public AchSommierEnteteDTO getById(Long id) {
        AchSommierEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchSommierEnteteDTO> query(AchSommierEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchSommierEnteteDTO toDTO(AchSommierEntete original) {
        AchSommierEnteteDTO bean = new AchSommierEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchSommierEntete requireOne(Long id) {
        return achSommierEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
