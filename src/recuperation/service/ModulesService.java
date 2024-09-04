package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Modules;
import com.yewi.yewicore.recuperation.dtos.ModulesDTO;
import com.yewi.yewicore.recuperation.repository.ModulesRepository;
import com.yewi.yewicore.recuperation.vo.ModulesQueryVO;
import com.yewi.yewicore.recuperation.vo.ModulesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ModulesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ModulesService {

    @Autowired
    private ModulesRepository modulesRepository;

    public String save(ModulesVO vO) {
        Modules bean = new Modules();
        BeanUtils.copyProperties(vO, bean);
        bean = modulesRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        modulesRepository.deleteById(id);
    }

    public void update(String id, ModulesUpdateVO vO) {
        Modules bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        modulesRepository.save(bean);
    }

    public ModulesDTO getById(String id) {
        Modules original = requireOne(id);
        return toDTO(original);
    }

    public Page<ModulesDTO> query(ModulesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ModulesDTO toDTO(Modules original) {
        ModulesDTO bean = new ModulesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Modules requireOne(String id) {
        return modulesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
