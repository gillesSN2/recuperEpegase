package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCommandeEntete;
import com.yewi.yewicore.recuperation.dtos.AchCommandeEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchCommandeEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCommandeEnteteService {

    @Autowired
    private AchCommandeEnteteRepository achCommandeEnteteRepository;

    public Long save(AchCommandeEnteteVO vO) {
        AchCommandeEntete bean = new AchCommandeEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achCommandeEnteteRepository.save(bean);
        return bean.getCmdId();
    }

    public void delete(Long id) {
        achCommandeEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchCommandeEnteteUpdateVO vO) {
        AchCommandeEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCommandeEnteteRepository.save(bean);
    }

    public AchCommandeEnteteDTO getById(Long id) {
        AchCommandeEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCommandeEnteteDTO> query(AchCommandeEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCommandeEnteteDTO toDTO(AchCommandeEntete original) {
        AchCommandeEnteteDTO bean = new AchCommandeEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCommandeEntete requireOne(Long id) {
        return achCommandeEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
