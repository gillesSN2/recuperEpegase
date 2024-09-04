package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsPharmacie;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsPharmacieDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsPharmacieRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsPharmacieService {

    @Autowired
    private CmmProduitsPharmacieRepository cmmProduitsPharmacieRepository;

    public Long save(CmmProduitsPharmacieVO vO) {
        CmmProduitsPharmacie bean = new CmmProduitsPharmacie();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsPharmacieRepository.save(bean);
        return bean.getProphaId();
    }

    public void delete(Long id) {
        cmmProduitsPharmacieRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsPharmacieUpdateVO vO) {
        CmmProduitsPharmacie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsPharmacieRepository.save(bean);
    }

    public CmmProduitsPharmacieDTO getById(Long id) {
        CmmProduitsPharmacie original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsPharmacieDTO> query(CmmProduitsPharmacieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsPharmacieDTO toDTO(CmmProduitsPharmacie original) {
        CmmProduitsPharmacieDTO bean = new CmmProduitsPharmacieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsPharmacie requireOne(Long id) {
        return cmmProduitsPharmacieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
