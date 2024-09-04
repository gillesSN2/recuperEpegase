package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptTabResultats;
import com.yewi.yewicore.recuperation.dtos.CptTabResultatsDTO;
import com.yewi.yewicore.recuperation.repository.CptTabResultatsRepository;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptTabResultatsService {

    @Autowired
    private CptTabResultatsRepository cptTabResultatsRepository;

    public Long save(CptTabResultatsVO vO) {
        CptTabResultats bean = new CptTabResultats();
        BeanUtils.copyProperties(vO, bean);
        bean = cptTabResultatsRepository.save(bean);
        return bean.getTabresId();
    }

    public void delete(Long id) {
        cptTabResultatsRepository.deleteById(id);
    }

    public void update(Long id, CptTabResultatsUpdateVO vO) {
        CptTabResultats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptTabResultatsRepository.save(bean);
    }

    public CptTabResultatsDTO getById(Long id) {
        CptTabResultats original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptTabResultatsDTO> query(CptTabResultatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptTabResultatsDTO toDTO(CptTabResultats original) {
        CptTabResultatsDTO bean = new CptTabResultatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptTabResultats requireOne(Long id) {
        return cptTabResultatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
