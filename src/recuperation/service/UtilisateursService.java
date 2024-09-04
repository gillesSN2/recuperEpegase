package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Utilisateurs;
import com.yewi.yewicore.recuperation.dtos.UtilisateursDTO;
import com.yewi.yewicore.recuperation.repository.UtilisateursRepository;
import com.yewi.yewicore.recuperation.vo.UtilisateursQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    public Long save(UtilisateursVO vO) {
        Utilisateurs bean = new Utilisateurs();
        BeanUtils.copyProperties(vO, bean);
        bean = utilisateursRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        utilisateursRepository.deleteById(id);
    }

    public void update(Long id, UtilisateursUpdateVO vO) {
        Utilisateurs bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        utilisateursRepository.save(bean);
    }

    public UtilisateursDTO getById(Long id) {
        Utilisateurs original = requireOne(id);
        return toDTO(original);
    }

    public Page<UtilisateursDTO> query(UtilisateursQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UtilisateursDTO toDTO(Utilisateurs original) {
        UtilisateursDTO bean = new UtilisateursDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Utilisateurs requireOne(Long id) {
        return utilisateursRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
