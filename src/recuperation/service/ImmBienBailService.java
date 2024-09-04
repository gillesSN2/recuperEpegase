package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienBail;
import com.yewi.yewicore.recuperation.dtos.ImmBienBailDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienBailRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienBailQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienBailUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienBailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienBailService {

    @Autowired
    private ImmBienBailRepository immBienBailRepository;

    public Long save(ImmBienBailVO vO) {
        ImmBienBail bean = new ImmBienBail();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienBailRepository.save(bean);
        return bean.getBiebaiId();
    }

    public void delete(Long id) {
        immBienBailRepository.deleteById(id);
    }

    public void update(Long id, ImmBienBailUpdateVO vO) {
        ImmBienBail bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienBailRepository.save(bean);
    }

    public ImmBienBailDTO getById(Long id) {
        ImmBienBail original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienBailDTO> query(ImmBienBailQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienBailDTO toDTO(ImmBienBail original) {
        ImmBienBailDTO bean = new ImmBienBailDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienBail requireOne(Long id) {
        return immBienBailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
