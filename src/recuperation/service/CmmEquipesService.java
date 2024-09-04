package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmEquipes;
import com.yewi.yewicore.recuperation.dtos.CmmEquipesDTO;
import com.yewi.yewicore.recuperation.repository.CmmEquipesRepository;
import com.yewi.yewicore.recuperation.vo.CmmEquipesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmEquipesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmEquipesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmEquipesService {

    @Autowired
    private CmmEquipesRepository cmmEquipesRepository;

    public Long save(CmmEquipesVO vO) {
        CmmEquipes bean = new CmmEquipes();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmEquipesRepository.save(bean);
        return bean.getEquId();
    }

    public void delete(Long id) {
        cmmEquipesRepository.deleteById(id);
    }

    public void update(Long id, CmmEquipesUpdateVO vO) {
        CmmEquipes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmEquipesRepository.save(bean);
    }

    public CmmEquipesDTO getById(Long id) {
        CmmEquipes original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmEquipesDTO> query(CmmEquipesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmEquipesDTO toDTO(CmmEquipes original) {
        CmmEquipesDTO bean = new CmmEquipesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmEquipes requireOne(Long id) {
        return cmmEquipesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
