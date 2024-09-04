package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Departements;
import com.yewi.yewicore.recuperation.dtos.DepartementsDTO;
import com.yewi.yewicore.recuperation.repository.DepartementsRepository;
import com.yewi.yewicore.recuperation.vo.DepartementsQueryVO;
import com.yewi.yewicore.recuperation.vo.DepartementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.DepartementsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DepartementsService {

    @Autowired
    private DepartementsRepository departementsRepository;

    public Long save(DepartementsVO vO) {
        Departements bean = new Departements();
        BeanUtils.copyProperties(vO, bean);
        bean = departementsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        departementsRepository.deleteById(id);
    }

    public void update(Long id, DepartementsUpdateVO vO) {
        Departements bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        departementsRepository.save(bean);
    }

    public DepartementsDTO getById(Long id) {
        Departements original = requireOne(id);
        return toDTO(original);
    }

    public Page<DepartementsDTO> query(DepartementsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DepartementsDTO toDTO(Departements original) {
        DepartementsDTO bean = new DepartementsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Departements requireOne(Long id) {
        return departementsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
