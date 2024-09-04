package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsFrais;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsFraisDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsFraisRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsFraisService {

    @Autowired
    private CmmProduitsFraisRepository cmmProduitsFraisRepository;

    public Long save(CmmProduitsFraisVO vO) {
        CmmProduitsFrais bean = new CmmProduitsFrais();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsFraisRepository.save(bean);
        return bean.getProfrsId();
    }

    public void delete(Long id) {
        cmmProduitsFraisRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsFraisUpdateVO vO) {
        CmmProduitsFrais bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsFraisRepository.save(bean);
    }

    public CmmProduitsFraisDTO getById(Long id) {
        CmmProduitsFrais original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsFraisDTO> query(CmmProduitsFraisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsFraisDTO toDTO(CmmProduitsFrais original) {
        CmmProduitsFraisDTO bean = new CmmProduitsFraisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsFrais requireOne(Long id) {
        return cmmProduitsFraisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
