package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCotationsEntete;
import com.yewi.yewicore.recuperation.dtos.AchCotationsEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchCotationsEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCotationsEnteteService {

    @Autowired
    private AchCotationsEnteteRepository achCotationsEnteteRepository;

    public Long save(AchCotationsEnteteVO vO) {
        AchCotationsEntete bean = new AchCotationsEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achCotationsEnteteRepository.save(bean);
        return bean.getCotId();
    }

    public void delete(Long id) {
        achCotationsEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchCotationsEnteteUpdateVO vO) {
        AchCotationsEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCotationsEnteteRepository.save(bean);
    }

    public AchCotationsEnteteDTO getById(Long id) {
        AchCotationsEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCotationsEnteteDTO> query(AchCotationsEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCotationsEnteteDTO toDTO(AchCotationsEntete original) {
        AchCotationsEnteteDTO bean = new AchCotationsEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCotationsEntete requireOne(Long id) {
        return achCotationsEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
