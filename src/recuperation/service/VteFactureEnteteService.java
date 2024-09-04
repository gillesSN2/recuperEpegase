package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteFactureEntete;
import com.yewi.yewicore.recuperation.dtos.VteFactureEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteFactureEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteFactureEnteteService {

    @Autowired
    private VteFactureEnteteRepository vteFactureEnteteRepository;

    public Long save(VteFactureEnteteVO vO) {
        VteFactureEntete bean = new VteFactureEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteFactureEnteteRepository.save(bean);
        return bean.getFacId();
    }

    public void delete(Long id) {
        vteFactureEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteFactureEnteteUpdateVO vO) {
        VteFactureEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteFactureEnteteRepository.save(bean);
    }

    public VteFactureEnteteDTO getById(Long id) {
        VteFactureEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteFactureEnteteDTO> query(VteFactureEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteFactureEnteteDTO toDTO(VteFactureEntete original) {
        VteFactureEnteteDTO bean = new VteFactureEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteFactureEntete requireOne(Long id) {
        return vteFactureEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
