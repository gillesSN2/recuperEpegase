package recuperation.service;

import com.yewi.yewicore.recuperation.domain.OptionsTiers;
import com.yewi.yewicore.recuperation.dtos.OptionsTiersDTO;
import com.yewi.yewicore.recuperation.repository.OptionsTiersRepository;
import com.yewi.yewicore.recuperation.vo.OptionsTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.OptionsTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.OptionsTiersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OptionsTiersService {

    @Autowired
    private OptionsTiersRepository optionsTiersRepository;

    public String save(OptionsTiersVO vO) {
        OptionsTiers bean = new OptionsTiers();
        BeanUtils.copyProperties(vO, bean);
        bean = optionsTiersRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        optionsTiersRepository.deleteById(id);
    }

    public void update(String id, OptionsTiersUpdateVO vO) {
        OptionsTiers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        optionsTiersRepository.save(bean);
    }

    public OptionsTiersDTO getById(String id) {
        OptionsTiers original = requireOne(id);
        return toDTO(original);
    }

    public Page<OptionsTiersDTO> query(OptionsTiersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OptionsTiersDTO toDTO(OptionsTiers original) {
        OptionsTiersDTO bean = new OptionsTiersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private OptionsTiers requireOne(String id) {
        return optionsTiersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
