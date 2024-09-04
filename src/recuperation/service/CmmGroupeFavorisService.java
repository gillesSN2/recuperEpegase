package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmGroupeFavoris;
import com.yewi.yewicore.recuperation.dtos.CmmGroupeFavorisDTO;
import com.yewi.yewicore.recuperation.repository.CmmGroupeFavorisRepository;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmGroupeFavorisService {

    @Autowired
    private CmmGroupeFavorisRepository cmmGroupeFavorisRepository;

    public Long save(CmmGroupeFavorisVO vO) {
        CmmGroupeFavoris bean = new CmmGroupeFavoris();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmGroupeFavorisRepository.save(bean);
        return bean.getGrpfavId();
    }

    public void delete(Long id) {
        cmmGroupeFavorisRepository.deleteById(id);
    }

    public void update(Long id, CmmGroupeFavorisUpdateVO vO) {
        CmmGroupeFavoris bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmGroupeFavorisRepository.save(bean);
    }

    public CmmGroupeFavorisDTO getById(Long id) {
        CmmGroupeFavoris original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmGroupeFavorisDTO> query(CmmGroupeFavorisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmGroupeFavorisDTO toDTO(CmmGroupeFavoris original) {
        CmmGroupeFavorisDTO bean = new CmmGroupeFavorisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmGroupeFavoris requireOne(Long id) {
        return cmmGroupeFavorisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
