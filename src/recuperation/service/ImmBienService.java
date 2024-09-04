package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBien;
import com.yewi.yewicore.recuperation.dtos.ImmBienDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienService {

    @Autowired
    private ImmBienRepository immBienRepository;

    public Long save(ImmBienVO vO) {
        ImmBien bean = new ImmBien();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienRepository.save(bean);
        return bean.getBieId();
    }

    public void delete(Long id) {
        immBienRepository.deleteById(id);
    }

    public void update(Long id, ImmBienUpdateVO vO) {
        ImmBien bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienRepository.save(bean);
    }

    public ImmBienDTO getById(Long id) {
        ImmBien original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienDTO> query(ImmBienQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienDTO toDTO(ImmBien original) {
        ImmBienDTO bean = new ImmBienDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBien requireOne(Long id) {
        return immBienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
