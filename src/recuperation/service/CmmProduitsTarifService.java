package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsTarif;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsTarifDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsTarifRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsTarifService {

    @Autowired
    private CmmProduitsTarifRepository cmmProduitsTarifRepository;

    public Long save(CmmProduitsTarifVO vO) {
        CmmProduitsTarif bean = new CmmProduitsTarif();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsTarifRepository.save(bean);
        return bean.getProtarId();
    }

    public void delete(Long id) {
        cmmProduitsTarifRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsTarifUpdateVO vO) {
        CmmProduitsTarif bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsTarifRepository.save(bean);
    }

    public CmmProduitsTarifDTO getById(Long id) {
        CmmProduitsTarif original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsTarifDTO> query(CmmProduitsTarifQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsTarifDTO toDTO(CmmProduitsTarif original) {
        CmmProduitsTarifDTO bean = new CmmProduitsTarifDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsTarif requireOne(Long id) {
        return cmmProduitsTarifRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
