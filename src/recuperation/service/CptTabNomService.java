package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptTabNom;
import com.yewi.yewicore.recuperation.dtos.CptTabNomDTO;
import com.yewi.yewicore.recuperation.repository.CptTabNomRepository;
import com.yewi.yewicore.recuperation.vo.CptTabNomQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabNomUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabNomVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptTabNomService {

    @Autowired
    private CptTabNomRepository cptTabNomRepository;

    public Long save(CptTabNomVO vO) {
        CptTabNom bean = new CptTabNom();
        BeanUtils.copyProperties(vO, bean);
        bean = cptTabNomRepository.save(bean);
        return bean.getTablisId();
    }

    public void delete(Long id) {
        cptTabNomRepository.deleteById(id);
    }

    public void update(Long id, CptTabNomUpdateVO vO) {
        CptTabNom bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptTabNomRepository.save(bean);
    }

    public CptTabNomDTO getById(Long id) {
        CptTabNom original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptTabNomDTO> query(CptTabNomQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptTabNomDTO toDTO(CptTabNom original) {
        CptTabNomDTO bean = new CptTabNomDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptTabNom requireOne(Long id) {
        return cptTabNomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
