package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFactureEntete;
import com.yewi.yewicore.recuperation.dtos.AchFactureEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchFactureEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFactureEnteteService {

    @Autowired
    private AchFactureEnteteRepository achFactureEnteteRepository;

    public Long save(AchFactureEnteteVO vO) {
        AchFactureEntete bean = new AchFactureEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achFactureEnteteRepository.save(bean);
        return bean.getFcfId();
    }

    public void delete(Long id) {
        achFactureEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchFactureEnteteUpdateVO vO) {
        AchFactureEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFactureEnteteRepository.save(bean);
    }

    public AchFactureEnteteDTO getById(Long id) {
        AchFactureEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFactureEnteteDTO> query(AchFactureEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFactureEnteteDTO toDTO(AchFactureEntete original) {
        AchFactureEnteteDTO bean = new AchFactureEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFactureEntete requireOne(Long id) {
        return achFactureEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
