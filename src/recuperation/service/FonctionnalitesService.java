package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Fonctionnalites;
import com.yewi.yewicore.recuperation.dtos.FonctionnalitesDTO;
import com.yewi.yewicore.recuperation.repository.FonctionnalitesRepository;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesQueryVO;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FonctionnalitesService {

    @Autowired
    private FonctionnalitesRepository fonctionnalitesRepository;

    public String save(FonctionnalitesVO vO) {
        Fonctionnalites bean = new Fonctionnalites();
        BeanUtils.copyProperties(vO, bean);
        bean = fonctionnalitesRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        fonctionnalitesRepository.deleteById(id);
    }

    public void update(String id, FonctionnalitesUpdateVO vO) {
        Fonctionnalites bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        fonctionnalitesRepository.save(bean);
    }

    public FonctionnalitesDTO getById(String id) {
        Fonctionnalites original = requireOne(id);
        return toDTO(original);
    }

    public Page<FonctionnalitesDTO> query(FonctionnalitesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FonctionnalitesDTO toDTO(Fonctionnalites original) {
        FonctionnalitesDTO bean = new FonctionnalitesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Fonctionnalites requireOne(String id) {
        return fonctionnalitesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
