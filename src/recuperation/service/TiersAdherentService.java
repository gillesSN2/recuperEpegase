package recuperation.service;

import com.yewi.yewicore.recuperation.domain.TiersAdherent;
import com.yewi.yewicore.recuperation.dtos.TiersAdherentDTO;
import com.yewi.yewicore.recuperation.repository.TiersAdherentRepository;
import com.yewi.yewicore.recuperation.vo.TiersAdherentQueryVO;
import com.yewi.yewicore.recuperation.vo.TiersAdherentUpdateVO;
import com.yewi.yewicore.recuperation.vo.TiersAdherentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TiersAdherentService {

    @Autowired
    private TiersAdherentRepository tiersAdherentRepository;

    public Long save(TiersAdherentVO vO) {
        TiersAdherent bean = new TiersAdherent();
        BeanUtils.copyProperties(vO, bean);
        bean = tiersAdherentRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        tiersAdherentRepository.deleteById(id);
    }

    public void update(Long id, TiersAdherentUpdateVO vO) {
        TiersAdherent bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        tiersAdherentRepository.save(bean);
    }

    public TiersAdherentDTO getById(Long id) {
        TiersAdherent original = requireOne(id);
        return toDTO(original);
    }

    public Page<TiersAdherentDTO> query(TiersAdherentQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TiersAdherentDTO toDTO(TiersAdherent original) {
        TiersAdherentDTO bean = new TiersAdherentDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private TiersAdherent requireOne(Long id) {
        return tiersAdherentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
