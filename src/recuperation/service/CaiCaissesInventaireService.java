package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiCaissesInventaire;
import com.yewi.yewicore.recuperation.dtos.CaiCaissesInventaireDTO;
import com.yewi.yewicore.recuperation.repository.CaiCaissesInventaireRepository;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiCaissesInventaireService {

    @Autowired
    private CaiCaissesInventaireRepository caiCaissesInventaireRepository;

    public Long save(CaiCaissesInventaireVO vO) {
        CaiCaissesInventaire bean = new CaiCaissesInventaire();
        BeanUtils.copyProperties(vO, bean);
        bean = caiCaissesInventaireRepository.save(bean);
        return bean.getCaiinvId();
    }

    public void delete(Long id) {
        caiCaissesInventaireRepository.deleteById(id);
    }

    public void update(Long id, CaiCaissesInventaireUpdateVO vO) {
        CaiCaissesInventaire bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiCaissesInventaireRepository.save(bean);
    }

    public CaiCaissesInventaireDTO getById(Long id) {
        CaiCaissesInventaire original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiCaissesInventaireDTO> query(CaiCaissesInventaireQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiCaissesInventaireDTO toDTO(CaiCaissesInventaire original) {
        CaiCaissesInventaireDTO bean = new CaiCaissesInventaireDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiCaissesInventaire requireOne(Long id) {
        return caiCaissesInventaireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
