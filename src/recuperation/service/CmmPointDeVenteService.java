package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmPointDeVente;
import com.yewi.yewicore.recuperation.dtos.CmmPointDeVenteDTO;
import com.yewi.yewicore.recuperation.repository.CmmPointDeVenteRepository;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmPointDeVenteService {

    @Autowired
    private CmmPointDeVenteRepository cmmPointDeVenteRepository;

    public Long save(CmmPointDeVenteVO vO) {
        CmmPointDeVente bean = new CmmPointDeVente();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmPointDeVenteRepository.save(bean);
        return bean.getPdvId();
    }

    public void delete(Long id) {
        cmmPointDeVenteRepository.deleteById(id);
    }

    public void update(Long id, CmmPointDeVenteUpdateVO vO) {
        CmmPointDeVente bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmPointDeVenteRepository.save(bean);
    }

    public CmmPointDeVenteDTO getById(Long id) {
        CmmPointDeVente original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmPointDeVenteDTO> query(CmmPointDeVenteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmPointDeVenteDTO toDTO(CmmPointDeVente original) {
        CmmPointDeVenteDTO bean = new CmmPointDeVenteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmPointDeVente requireOne(Long id) {
        return cmmPointDeVenteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
