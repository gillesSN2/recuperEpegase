package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptRacines;
import com.yewi.yewicore.recuperation.dtos.CptRacinesDTO;
import com.yewi.yewicore.recuperation.repository.CptRacinesRepository;
import com.yewi.yewicore.recuperation.vo.CptRacinesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptRacinesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptRacinesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptRacinesService {

    @Autowired
    private CptRacinesRepository cptRacinesRepository;

    public Long save(CptRacinesVO vO) {
        CptRacines bean = new CptRacines();
        BeanUtils.copyProperties(vO, bean);
        bean = cptRacinesRepository.save(bean);
        return bean.getRacId();
    }

    public void delete(Long id) {
        cptRacinesRepository.deleteById(id);
    }

    public void update(Long id, CptRacinesUpdateVO vO) {
        CptRacines bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptRacinesRepository.save(bean);
    }

    public CptRacinesDTO getById(Long id) {
        CptRacines original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptRacinesDTO> query(CptRacinesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptRacinesDTO toDTO(CptRacines original) {
        CptRacinesDTO bean = new CptRacinesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptRacines requireOne(Long id) {
        return cptRacinesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
