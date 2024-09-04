package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchReceptionEntete;
import com.yewi.yewicore.recuperation.dtos.AchReceptionEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchReceptionEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchReceptionEnteteService {

    @Autowired
    private AchReceptionEnteteRepository achReceptionEnteteRepository;

    public Long save(AchReceptionEnteteVO vO) {
        AchReceptionEntete bean = new AchReceptionEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achReceptionEnteteRepository.save(bean);
        return bean.getRecId();
    }

    public void delete(Long id) {
        achReceptionEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchReceptionEnteteUpdateVO vO) {
        AchReceptionEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achReceptionEnteteRepository.save(bean);
    }

    public AchReceptionEnteteDTO getById(Long id) {
        AchReceptionEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchReceptionEnteteDTO> query(AchReceptionEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchReceptionEnteteDTO toDTO(AchReceptionEntete original) {
        AchReceptionEnteteDTO bean = new AchReceptionEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchReceptionEntete requireOne(Long id) {
        return achReceptionEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
