package recuperation.service;

import com.yewi.yewicore.recuperation.domain.FamilleClient;
import com.yewi.yewicore.recuperation.dtos.FamilleClientDTO;
import com.yewi.yewicore.recuperation.repository.FamilleClientRepository;
import com.yewi.yewicore.recuperation.vo.FamilleClientQueryVO;
import com.yewi.yewicore.recuperation.vo.FamilleClientUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamilleClientVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FamilleClientService {

    @Autowired
    private FamilleClientRepository familleClientRepository;

    public Long save(FamilleClientVO vO) {
        FamilleClient bean = new FamilleClient();
        BeanUtils.copyProperties(vO, bean);
        bean = familleClientRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        familleClientRepository.deleteById(id);
    }

    public void update(Long id, FamilleClientUpdateVO vO) {
        FamilleClient bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        familleClientRepository.save(bean);
    }

    public FamilleClientDTO getById(Long id) {
        FamilleClient original = requireOne(id);
        return toDTO(original);
    }

    public Page<FamilleClientDTO> query(FamilleClientQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FamilleClientDTO toDTO(FamilleClient original) {
        FamilleClientDTO bean = new FamilleClientDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FamilleClient requireOne(Long id) {
        return familleClientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
