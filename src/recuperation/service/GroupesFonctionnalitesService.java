package recuperation.service;

import com.yewi.yewicore.recuperation.domain.GroupesFonctionnalites;
import com.yewi.yewicore.recuperation.dtos.GroupesFonctionnalitesDTO;
import com.yewi.yewicore.recuperation.repository.GroupesFonctionnalitesRepository;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupesFonctionnalitesService {

    @Autowired
    private GroupesFonctionnalitesRepository groupesFonctionnalitesRepository;

    public String save(GroupesFonctionnalitesVO vO) {
        GroupesFonctionnalites bean = new GroupesFonctionnalites();
        BeanUtils.copyProperties(vO, bean);
        bean = groupesFonctionnalitesRepository.save(bean);
        return bean.getGroupesId();
    }

    public void delete(String id) {
        groupesFonctionnalitesRepository.deleteById(id);
    }

    public void update(String id, GroupesFonctionnalitesUpdateVO vO) {
        GroupesFonctionnalites bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        groupesFonctionnalitesRepository.save(bean);
    }

    public GroupesFonctionnalitesDTO getById(String id) {
        GroupesFonctionnalites original = requireOne(id);
        return toDTO(original);
    }

    public Page<GroupesFonctionnalitesDTO> query(GroupesFonctionnalitesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GroupesFonctionnalitesDTO toDTO(GroupesFonctionnalites original) {
        GroupesFonctionnalitesDTO bean = new GroupesFonctionnalitesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private GroupesFonctionnalites requireOne(String id) {
        return groupesFonctionnalitesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
