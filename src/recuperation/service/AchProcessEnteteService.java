package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchProcessEntete;
import com.yewi.yewicore.recuperation.dtos.AchProcessEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchProcessEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchProcessEnteteService {

    @Autowired
    private AchProcessEnteteRepository achProcessEnteteRepository;

    public Long save(AchProcessEnteteVO vO) {
        AchProcessEntete bean = new AchProcessEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achProcessEnteteRepository.save(bean);
        return bean.getProcesId();
    }

    public void delete(Long id) {
        achProcessEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchProcessEnteteUpdateVO vO) {
        AchProcessEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achProcessEnteteRepository.save(bean);
    }

    public AchProcessEnteteDTO getById(Long id) {
        AchProcessEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchProcessEnteteDTO> query(AchProcessEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchProcessEnteteDTO toDTO(AchProcessEntete original) {
        AchProcessEnteteDTO bean = new AchProcessEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchProcessEntete requireOne(Long id) {
        return achProcessEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
