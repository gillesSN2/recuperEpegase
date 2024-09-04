package recuperation.service;

import com.yewi.yewicore.recuperation.domain.FamillesFournisseurs;
import com.yewi.yewicore.recuperation.dtos.FamillesFournisseursDTO;
import com.yewi.yewicore.recuperation.repository.FamillesFournisseursRepository;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursQueryVO;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FamillesFournisseursService {

    @Autowired
    private FamillesFournisseursRepository famillesFournisseursRepository;

    public Long save(FamillesFournisseursVO vO) {
        FamillesFournisseurs bean = new FamillesFournisseurs();
        BeanUtils.copyProperties(vO, bean);
        bean = famillesFournisseursRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        famillesFournisseursRepository.deleteById(id);
    }

    public void update(Long id, FamillesFournisseursUpdateVO vO) {
        FamillesFournisseurs bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        famillesFournisseursRepository.save(bean);
    }

    public FamillesFournisseursDTO getById(Long id) {
        FamillesFournisseurs original = requireOne(id);
        return toDTO(original);
    }

    public Page<FamillesFournisseursDTO> query(FamillesFournisseursQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FamillesFournisseursDTO toDTO(FamillesFournisseurs original) {
        FamillesFournisseursDTO bean = new FamillesFournisseursDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FamillesFournisseurs requireOne(Long id) {
        return famillesFournisseursRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
