package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Tiers;
import com.yewi.yewicore.recuperation.dtos.TiersDTO;
import com.yewi.yewicore.recuperation.repository.TiersRepository;
import com.yewi.yewicore.recuperation.vo.TiersQueryVO;
import com.yewi.yewicore.recuperation.vo.TiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.TiersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TiersService {

    @Autowired
    private TiersRepository tiersRepository;

    public Long save(TiersVO vO) {
        Tiers bean = new Tiers();
        BeanUtils.copyProperties(vO, bean);
        bean = tiersRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        tiersRepository.deleteById(id);
    }

    public void update(Long id, TiersUpdateVO vO) {
        Tiers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        tiersRepository.save(bean);
    }

    public TiersDTO getById(Long id) {
        Tiers original = requireOne(id);
        return toDTO(original);
    }

    public Page<TiersDTO> query(TiersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TiersDTO toDTO(Tiers original) {
        TiersDTO bean = new TiersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Tiers requireOne(Long id) {
        return tiersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
