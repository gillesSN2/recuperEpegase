package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBesoinLigne;
import com.yewi.yewicore.recuperation.dtos.VteBesoinLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteBesoinLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBesoinLigneService {

    @Autowired
    private VteBesoinLigneRepository vteBesoinLigneRepository;

    public Long save(VteBesoinLigneVO vO) {
        VteBesoinLigne bean = new VteBesoinLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBesoinLigneRepository.save(bean);
        return bean.getBesligId();
    }

    public void delete(Long id) {
        vteBesoinLigneRepository.deleteById(id);
    }

    public void update(Long id, VteBesoinLigneUpdateVO vO) {
        VteBesoinLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBesoinLigneRepository.save(bean);
    }

    public VteBesoinLigneDTO getById(Long id) {
        VteBesoinLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBesoinLigneDTO> query(VteBesoinLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBesoinLigneDTO toDTO(VteBesoinLigne original) {
        VteBesoinLigneDTO bean = new VteBesoinLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBesoinLigne requireOne(Long id) {
        return vteBesoinLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
