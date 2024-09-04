package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteContratLigne;
import com.yewi.yewicore.recuperation.dtos.VteContratLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteContratLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteContratLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteContratLigneService {

    @Autowired
    private VteContratLigneRepository vteContratLigneRepository;

    public Long save(VteContratLigneVO vO) {
        VteContratLigne bean = new VteContratLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteContratLigneRepository.save(bean);
        return bean.getCrtligId();
    }

    public void delete(Long id) {
        vteContratLigneRepository.deleteById(id);
    }

    public void update(Long id, VteContratLigneUpdateVO vO) {
        VteContratLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteContratLigneRepository.save(bean);
    }

    public VteContratLigneDTO getById(Long id) {
        VteContratLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteContratLigneDTO> query(VteContratLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteContratLigneDTO toDTO(VteContratLigne original) {
        VteContratLigneDTO bean = new VteContratLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteContratLigne requireOne(Long id) {
        return vteContratLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
