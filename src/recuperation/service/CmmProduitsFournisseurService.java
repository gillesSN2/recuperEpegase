package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsFournisseur;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsFournisseurDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsFournisseurRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsFournisseurService {

    @Autowired
    private CmmProduitsFournisseurRepository cmmProduitsFournisseurRepository;

    public Long save(CmmProduitsFournisseurVO vO) {
        CmmProduitsFournisseur bean = new CmmProduitsFournisseur();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsFournisseurRepository.save(bean);
        return bean.getProfouId();
    }

    public void delete(Long id) {
        cmmProduitsFournisseurRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsFournisseurUpdateVO vO) {
        CmmProduitsFournisseur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsFournisseurRepository.save(bean);
    }

    public CmmProduitsFournisseurDTO getById(Long id) {
        CmmProduitsFournisseur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsFournisseurDTO> query(CmmProduitsFournisseurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsFournisseurDTO toDTO(CmmProduitsFournisseur original) {
        CmmProduitsFournisseurDTO bean = new CmmProduitsFournisseurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsFournisseur requireOne(Long id) {
        return cmmProduitsFournisseurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
