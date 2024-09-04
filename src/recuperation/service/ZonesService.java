package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Zones;
import com.yewi.yewicore.recuperation.dtos.ZonesDTO;
import com.yewi.yewicore.recuperation.repository.ZonesRepository;
import com.yewi.yewicore.recuperation.vo.ZonesQueryVO;
import com.yewi.yewicore.recuperation.vo.ZonesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ZonesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ZonesService {

    @Autowired
    private ZonesRepository zonesRepository;

    public Long save(ZonesVO vO) {
        Zones bean = new Zones();
        BeanUtils.copyProperties(vO, bean);
        bean = zonesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        zonesRepository.deleteById(id);
    }

    public void update(Long id, ZonesUpdateVO vO) {
        Zones bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        zonesRepository.save(bean);
    }

    public ZonesDTO getById(Long id) {
        Zones original = requireOne(id);
        return toDTO(original);
    }

    public Page<ZonesDTO> query(ZonesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ZonesDTO toDTO(Zones original) {
        ZonesDTO bean = new ZonesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Zones requireOne(Long id) {
        return zonesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
