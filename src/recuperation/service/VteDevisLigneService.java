package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteDevisLigne;
import com.yewi.yewicore.recuperation.dtos.VteDevisLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteDevisLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteDevisLigneService {

    @Autowired
    private VteDevisLigneRepository vteDevisLigneRepository;

    public Long save(VteDevisLigneVO vO) {
        VteDevisLigne bean = new VteDevisLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteDevisLigneRepository.save(bean);
        return bean.getDvsligId();
    }

    public void delete(Long id) {
        vteDevisLigneRepository.deleteById(id);
    }

    public void update(Long id, VteDevisLigneUpdateVO vO) {
        VteDevisLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteDevisLigneRepository.save(bean);
    }

    public VteDevisLigneDTO getById(Long id) {
        VteDevisLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteDevisLigneDTO> query(VteDevisLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteDevisLigneDTO toDTO(VteDevisLigne original) {
        VteDevisLigneDTO bean = new VteDevisLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteDevisLigne requireOne(Long id) {
        return vteDevisLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
