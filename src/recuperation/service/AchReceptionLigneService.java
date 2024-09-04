package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchReceptionLigne;
import com.yewi.yewicore.recuperation.dtos.AchReceptionLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchReceptionLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchReceptionLigneService {

    @Autowired
    private AchReceptionLigneRepository achReceptionLigneRepository;

    public Long save(AchReceptionLigneVO vO) {
        AchReceptionLigne bean = new AchReceptionLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achReceptionLigneRepository.save(bean);
        return bean.getRecligId();
    }

    public void delete(Long id) {
        achReceptionLigneRepository.deleteById(id);
    }

    public void update(Long id, AchReceptionLigneUpdateVO vO) {
        AchReceptionLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achReceptionLigneRepository.save(bean);
    }

    public AchReceptionLigneDTO getById(Long id) {
        AchReceptionLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchReceptionLigneDTO> query(AchReceptionLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchReceptionLigneDTO toDTO(AchReceptionLigne original) {
        AchReceptionLigneDTO bean = new AchReceptionLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchReceptionLigne requireOne(Long id) {
        return achReceptionLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
