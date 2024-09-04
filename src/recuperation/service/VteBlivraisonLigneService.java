package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBlivraisonLigne;
import com.yewi.yewicore.recuperation.dtos.VteBlivraisonLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteBlivraisonLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBlivraisonLigneService {

    @Autowired
    private VteBlivraisonLigneRepository vteBlivraisonLigneRepository;

    public Long save(VteBlivraisonLigneVO vO) {
        VteBlivraisonLigne bean = new VteBlivraisonLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBlivraisonLigneRepository.save(bean);
        return bean.getBlvligId();
    }

    public void delete(Long id) {
        vteBlivraisonLigneRepository.deleteById(id);
    }

    public void update(Long id, VteBlivraisonLigneUpdateVO vO) {
        VteBlivraisonLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBlivraisonLigneRepository.save(bean);
    }

    public VteBlivraisonLigneDTO getById(Long id) {
        VteBlivraisonLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBlivraisonLigneDTO> query(VteBlivraisonLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBlivraisonLigneDTO toDTO(VteBlivraisonLigne original) {
        VteBlivraisonLigneDTO bean = new VteBlivraisonLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBlivraisonLigne requireOne(Long id) {
        return vteBlivraisonLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
