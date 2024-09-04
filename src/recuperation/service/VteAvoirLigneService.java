package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteAvoirLigne;
import com.yewi.yewicore.recuperation.dtos.VteAvoirLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteAvoirLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteAvoirLigneService {

    @Autowired
    private VteAvoirLigneRepository vteAvoirLigneRepository;

    public Long save(VteAvoirLigneVO vO) {
        VteAvoirLigne bean = new VteAvoirLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteAvoirLigneRepository.save(bean);
        return bean.getAvrligId();
    }

    public void delete(Long id) {
        vteAvoirLigneRepository.deleteById(id);
    }

    public void update(Long id, VteAvoirLigneUpdateVO vO) {
        VteAvoirLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteAvoirLigneRepository.save(bean);
    }

    public VteAvoirLigneDTO getById(Long id) {
        VteAvoirLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteAvoirLigneDTO> query(VteAvoirLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteAvoirLigneDTO toDTO(VteAvoirLigne original) {
        VteAvoirLigneDTO bean = new VteAvoirLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteAvoirLigne requireOne(Long id) {
        return vteAvoirLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
