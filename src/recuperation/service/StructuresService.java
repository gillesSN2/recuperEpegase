package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Structures;
import com.yewi.yewicore.recuperation.dtos.StructuresDTO;
import com.yewi.yewicore.recuperation.repository.StructuresRepository;
import com.yewi.yewicore.recuperation.vo.StructuresQueryVO;
import com.yewi.yewicore.recuperation.vo.StructuresUpdateVO;
import com.yewi.yewicore.recuperation.vo.StructuresVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StructuresService {

    @Autowired
    private StructuresRepository structuresRepository;

    public Long save(StructuresVO vO) {
        Structures bean = new Structures();
        BeanUtils.copyProperties(vO, bean);
        bean = structuresRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        structuresRepository.deleteById(id);
    }

    public void update(Long id, StructuresUpdateVO vO) {
        Structures bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        structuresRepository.save(bean);
    }

    public StructuresDTO getById(Long id) {
        Structures original = requireOne(id);
        return toDTO(original);
    }

    public Page<StructuresDTO> query(StructuresQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private StructuresDTO toDTO(Structures original) {
        StructuresDTO bean = new StructuresDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Structures requireOne(Long id) {
        return structuresRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
