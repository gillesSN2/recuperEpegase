package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchDepot;
import com.yewi.yewicore.recuperation.dtos.AchDepotDTO;
import com.yewi.yewicore.recuperation.repository.AchDepotRepository;
import com.yewi.yewicore.recuperation.vo.AchDepotQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDepotUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDepotVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchDepotService {

    @Autowired
    private AchDepotRepository achDepotRepository;

    public Long save(AchDepotVO vO) {
        AchDepot bean = new AchDepot();
        BeanUtils.copyProperties(vO, bean);
        bean = achDepotRepository.save(bean);
        return bean.getDpoId();
    }

    public void delete(Long id) {
        achDepotRepository.deleteById(id);
    }

    public void update(Long id, AchDepotUpdateVO vO) {
        AchDepot bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achDepotRepository.save(bean);
    }

    public AchDepotDTO getById(Long id) {
        AchDepot original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchDepotDTO> query(AchDepotQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchDepotDTO toDTO(AchDepot original) {
        AchDepotDTO bean = new AchDepotDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchDepot requireOne(Long id) {
        return achDepotRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
