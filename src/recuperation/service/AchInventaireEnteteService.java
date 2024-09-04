package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchInventaireEntete;
import com.yewi.yewicore.recuperation.dtos.AchInventaireEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchInventaireEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchInventaireEnteteService {

    @Autowired
    private AchInventaireEnteteRepository achInventaireEnteteRepository;

    public Long save(AchInventaireEnteteVO vO) {
        AchInventaireEntete bean = new AchInventaireEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achInventaireEnteteRepository.save(bean);
        return bean.getInvId();
    }

    public void delete(Long id) {
        achInventaireEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchInventaireEnteteUpdateVO vO) {
        AchInventaireEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achInventaireEnteteRepository.save(bean);
    }

    public AchInventaireEnteteDTO getById(Long id) {
        AchInventaireEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchInventaireEnteteDTO> query(AchInventaireEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchInventaireEnteteDTO toDTO(AchInventaireEntete original) {
        AchInventaireEnteteDTO bean = new AchInventaireEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchInventaireEntete requireOne(Long id) {
        return achInventaireEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
