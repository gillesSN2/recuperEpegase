package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Groupes;
import com.yewi.yewicore.recuperation.dtos.GroupesDTO;
import com.yewi.yewicore.recuperation.repository.GroupesRepository;
import com.yewi.yewicore.recuperation.vo.GroupesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupesService {

    @Autowired
    private GroupesRepository groupesRepository;

    public Long save(GroupesVO vO) {
        Groupes bean = new Groupes();
        BeanUtils.copyProperties(vO, bean);
        bean = groupesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        groupesRepository.deleteById(id);
    }

    public void update(Long id, GroupesUpdateVO vO) {
        Groupes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        groupesRepository.save(bean);
    }

    public GroupesDTO getById(Long id) {
        Groupes original = requireOne(id);
        return toDTO(original);
    }

    public Page<GroupesDTO> query(GroupesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GroupesDTO toDTO(Groupes original) {
        GroupesDTO bean = new GroupesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Groupes requireOne(Long id) {
        return groupesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
