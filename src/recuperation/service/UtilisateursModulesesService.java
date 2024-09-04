package recuperation.service;

import com.yewi.yewicore.recuperation.domain.UtilisateursModuleses;
import com.yewi.yewicore.recuperation.dtos.UtilisateursModulesesDTO;
import com.yewi.yewicore.recuperation.repository.UtilisateursModulesesRepository;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UtilisateursModulesesService {

    @Autowired
    private UtilisateursModulesesRepository utilisateursModulesesRepository;

    public String save(UtilisateursModulesesVO vO) {
        UtilisateursModuleses bean = new UtilisateursModuleses();
        BeanUtils.copyProperties(vO, bean);
        bean = utilisateursModulesesRepository.save(bean);
        return bean.getUtilisateurId();
    }

    public void delete(String id) {
        utilisateursModulesesRepository.deleteById(id);
    }

    public void update(String id, UtilisateursModulesesUpdateVO vO) {
        UtilisateursModuleses bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        utilisateursModulesesRepository.save(bean);
    }

    public UtilisateursModulesesDTO getById(String id) {
        UtilisateursModuleses original = requireOne(id);
        return toDTO(original);
    }

    public Page<UtilisateursModulesesDTO> query(UtilisateursModulesesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UtilisateursModulesesDTO toDTO(UtilisateursModuleses original) {
        UtilisateursModulesesDTO bean = new UtilisateursModulesesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UtilisateursModuleses requireOne(String id) {
        return utilisateursModulesesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
