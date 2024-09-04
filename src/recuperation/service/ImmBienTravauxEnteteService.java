package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienTravauxEntete;
import com.yewi.yewicore.recuperation.dtos.ImmBienTravauxEnteteDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienTravauxEnteteRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienTravauxEnteteService {

    @Autowired
    private ImmBienTravauxEnteteRepository immBienTravauxEnteteRepository;

    public Long save(ImmBienTravauxEnteteVO vO) {
        ImmBienTravauxEntete bean = new ImmBienTravauxEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienTravauxEnteteRepository.save(bean);
        return bean.getBietraentId();
    }

    public void delete(Long id) {
        immBienTravauxEnteteRepository.deleteById(id);
    }

    public void update(Long id, ImmBienTravauxEnteteUpdateVO vO) {
        ImmBienTravauxEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienTravauxEnteteRepository.save(bean);
    }

    public ImmBienTravauxEnteteDTO getById(Long id) {
        ImmBienTravauxEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienTravauxEnteteDTO> query(ImmBienTravauxEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienTravauxEnteteDTO toDTO(ImmBienTravauxEntete original) {
        ImmBienTravauxEnteteDTO bean = new ImmBienTravauxEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienTravauxEntete requireOne(Long id) {
        return immBienTravauxEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
