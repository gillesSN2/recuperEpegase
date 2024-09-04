package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienGeranceEntete;
import com.yewi.yewicore.recuperation.dtos.ImmBienGeranceEnteteDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienGeranceEnteteRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienGeranceEnteteService {

    @Autowired
    private ImmBienGeranceEnteteRepository immBienGeranceEnteteRepository;

    public Long save(ImmBienGeranceEnteteVO vO) {
        ImmBienGeranceEntete bean = new ImmBienGeranceEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienGeranceEnteteRepository.save(bean);
        return bean.getBiegerentId();
    }

    public void delete(Long id) {
        immBienGeranceEnteteRepository.deleteById(id);
    }

    public void update(Long id, ImmBienGeranceEnteteUpdateVO vO) {
        ImmBienGeranceEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienGeranceEnteteRepository.save(bean);
    }

    public ImmBienGeranceEnteteDTO getById(Long id) {
        ImmBienGeranceEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienGeranceEnteteDTO> query(ImmBienGeranceEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienGeranceEnteteDTO toDTO(ImmBienGeranceEntete original) {
        ImmBienGeranceEnteteDTO bean = new ImmBienGeranceEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienGeranceEntete requireOne(Long id) {
        return immBienGeranceEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
