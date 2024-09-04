package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBretourLigne;
import com.yewi.yewicore.recuperation.dtos.VteBretourLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteBretourLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBretourLigneService {

    @Autowired
    private VteBretourLigneRepository vteBretourLigneRepository;

    public Long save(VteBretourLigneVO vO) {
        VteBretourLigne bean = new VteBretourLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBretourLigneRepository.save(bean);
        return bean.getBrtligId();
    }

    public void delete(Long id) {
        vteBretourLigneRepository.deleteById(id);
    }

    public void update(Long id, VteBretourLigneUpdateVO vO) {
        VteBretourLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBretourLigneRepository.save(bean);
    }

    public VteBretourLigneDTO getById(Long id) {
        VteBretourLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBretourLigneDTO> query(VteBretourLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBretourLigneDTO toDTO(VteBretourLigne original) {
        VteBretourLigneDTO bean = new VteBretourLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBretourLigne requireOne(Long id) {
        return vteBretourLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
