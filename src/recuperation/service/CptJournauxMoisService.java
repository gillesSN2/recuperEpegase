package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptJournauxMois;
import com.yewi.yewicore.recuperation.dtos.CptJournauxMoisDTO;
import com.yewi.yewicore.recuperation.repository.CptJournauxMoisRepository;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptJournauxMoisService {

    @Autowired
    private CptJournauxMoisRepository cptJournauxMoisRepository;

    public Long save(CptJournauxMoisVO vO) {
        CptJournauxMois bean = new CptJournauxMois();
        BeanUtils.copyProperties(vO, bean);
        bean = cptJournauxMoisRepository.save(bean);
        return bean.getJoumenId();
    }

    public void delete(Long id) {
        cptJournauxMoisRepository.deleteById(id);
    }

    public void update(Long id, CptJournauxMoisUpdateVO vO) {
        CptJournauxMois bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptJournauxMoisRepository.save(bean);
    }

    public CptJournauxMoisDTO getById(Long id) {
        CptJournauxMois original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptJournauxMoisDTO> query(CptJournauxMoisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptJournauxMoisDTO toDTO(CptJournauxMois original) {
        CptJournauxMoisDTO bean = new CptJournauxMoisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptJournauxMois requireOne(Long id) {
        return cptJournauxMoisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
