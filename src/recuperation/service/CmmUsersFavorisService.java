package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUsersFavoris;
import com.yewi.yewicore.recuperation.dtos.CmmUsersFavorisDTO;
import com.yewi.yewicore.recuperation.repository.CmmUsersFavorisRepository;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUsersFavorisService {

    @Autowired
    private CmmUsersFavorisRepository cmmUsersFavorisRepository;

    public Long save(CmmUsersFavorisVO vO) {
        CmmUsersFavoris bean = new CmmUsersFavoris();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUsersFavorisRepository.save(bean);
        return bean.getUsrfavId();
    }

    public void delete(Long id) {
        cmmUsersFavorisRepository.deleteById(id);
    }

    public void update(Long id, CmmUsersFavorisUpdateVO vO) {
        CmmUsersFavoris bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUsersFavorisRepository.save(bean);
    }

    public CmmUsersFavorisDTO getById(Long id) {
        CmmUsersFavoris original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUsersFavorisDTO> query(CmmUsersFavorisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUsersFavorisDTO toDTO(CmmUsersFavoris original) {
        CmmUsersFavorisDTO bean = new CmmUsersFavorisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUsersFavoris requireOne(Long id) {
        return cmmUsersFavorisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
