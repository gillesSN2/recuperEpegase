package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteDevisEntete;
import com.yewi.yewicore.recuperation.dtos.VteDevisEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteDevisEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteDevisEnteteService {

    @Autowired
    private VteDevisEnteteRepository vteDevisEnteteRepository;

    public Long save(VteDevisEnteteVO vO) {
        VteDevisEntete bean = new VteDevisEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteDevisEnteteRepository.save(bean);
        return bean.getDvsId();
    }

    public void delete(Long id) {
        vteDevisEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteDevisEnteteUpdateVO vO) {
        VteDevisEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteDevisEnteteRepository.save(bean);
    }

    public VteDevisEnteteDTO getById(Long id) {
        VteDevisEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteDevisEnteteDTO> query(VteDevisEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteDevisEnteteDTO toDTO(VteDevisEntete original) {
        VteDevisEnteteDTO bean = new VteDevisEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteDevisEntete requireOne(Long id) {
        return vteDevisEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
