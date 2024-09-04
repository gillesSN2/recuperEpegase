package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchRetourEntete;
import com.yewi.yewicore.recuperation.dtos.AchRetourEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchRetourEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchRetourEnteteService {

    @Autowired
    private AchRetourEnteteRepository achRetourEnteteRepository;

    public Long save(AchRetourEnteteVO vO) {
        AchRetourEntete bean = new AchRetourEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achRetourEnteteRepository.save(bean);
        return bean.getBrfId();
    }

    public void delete(Long id) {
        achRetourEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchRetourEnteteUpdateVO vO) {
        AchRetourEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achRetourEnteteRepository.save(bean);
    }

    public AchRetourEnteteDTO getById(Long id) {
        AchRetourEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchRetourEnteteDTO> query(AchRetourEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchRetourEnteteDTO toDTO(AchRetourEntete original) {
        AchRetourEnteteDTO bean = new AchRetourEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchRetourEntete requireOne(Long id) {
        return achRetourEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
