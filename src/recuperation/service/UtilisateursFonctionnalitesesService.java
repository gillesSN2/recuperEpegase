package recuperation.service;

import com.yewi.yewicore.recuperation.domain.UtilisateursFonctionnaliteses;
import com.yewi.yewicore.recuperation.dtos.UtilisateursFonctionnalitesesDTO;
import com.yewi.yewicore.recuperation.repository.UtilisateursFonctionnalitesesRepository;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UtilisateursFonctionnalitesesService {

    @Autowired
    private UtilisateursFonctionnalitesesRepository utilisateursFonctionnalitesesRepository;

    public String save(UtilisateursFonctionnalitesesVO vO) {
        UtilisateursFonctionnaliteses bean = new UtilisateursFonctionnaliteses();
        BeanUtils.copyProperties(vO, bean);
        bean = utilisateursFonctionnalitesesRepository.save(bean);
        return bean.getUtilisateurId();
    }

    public void delete(String id) {
        utilisateursFonctionnalitesesRepository.deleteById(id);
    }

    public void update(String id, UtilisateursFonctionnalitesesUpdateVO vO) {
        UtilisateursFonctionnaliteses bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        utilisateursFonctionnalitesesRepository.save(bean);
    }

    public UtilisateursFonctionnalitesesDTO getById(String id) {
        UtilisateursFonctionnaliteses original = requireOne(id);
        return toDTO(original);
    }

    public Page<UtilisateursFonctionnalitesesDTO> query(UtilisateursFonctionnalitesesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UtilisateursFonctionnalitesesDTO toDTO(UtilisateursFonctionnaliteses original) {
        UtilisateursFonctionnalitesesDTO bean = new UtilisateursFonctionnalitesesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UtilisateursFonctionnaliteses requireOne(String id) {
        return utilisateursFonctionnalitesesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
