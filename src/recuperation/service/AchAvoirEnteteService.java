package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchAvoirEntete;
import com.yewi.yewicore.recuperation.dtos.AchAvoirEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchAvoirEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchAvoirEnteteService {

    @Autowired
    private AchAvoirEnteteRepository achAvoirEnteteRepository;

    public Long save(AchAvoirEnteteVO vO) {
        AchAvoirEntete bean = new AchAvoirEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achAvoirEnteteRepository.save(bean);
        return bean.getAvfId();
    }

    public void delete(Long id) {
        achAvoirEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchAvoirEnteteUpdateVO vO) {
        AchAvoirEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achAvoirEnteteRepository.save(bean);
    }

    public AchAvoirEnteteDTO getById(Long id) {
        AchAvoirEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchAvoirEnteteDTO> query(AchAvoirEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchAvoirEnteteDTO toDTO(AchAvoirEntete original) {
        AchAvoirEnteteDTO bean = new AchAvoirEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchAvoirEntete requireOne(Long id) {
        return achAvoirEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
