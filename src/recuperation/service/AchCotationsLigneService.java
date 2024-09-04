package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCotationsLigne;
import com.yewi.yewicore.recuperation.dtos.AchCotationsLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchCotationsLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCotationsLigneService {

    @Autowired
    private AchCotationsLigneRepository achCotationsLigneRepository;

    public Long save(AchCotationsLigneVO vO) {
        AchCotationsLigne bean = new AchCotationsLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achCotationsLigneRepository.save(bean);
        return bean.getCotligId();
    }

    public void delete(Long id) {
        achCotationsLigneRepository.deleteById(id);
    }

    public void update(Long id, AchCotationsLigneUpdateVO vO) {
        AchCotationsLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCotationsLigneRepository.save(bean);
    }

    public AchCotationsLigneDTO getById(Long id) {
        AchCotationsLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCotationsLigneDTO> query(AchCotationsLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCotationsLigneDTO toDTO(AchCotationsLigne original) {
        AchCotationsLigneDTO bean = new AchCotationsLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCotationsLigne requireOne(Long id) {
        return achCotationsLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
