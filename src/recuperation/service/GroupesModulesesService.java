package recuperation.service;

import com.yewi.yewicore.recuperation.domain.GroupesModuleses;
import com.yewi.yewicore.recuperation.dtos.GroupesModulesesDTO;
import com.yewi.yewicore.recuperation.repository.GroupesModulesesRepository;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupesModulesesService {

    @Autowired
    private GroupesModulesesRepository groupesModulesesRepository;

    public String save(GroupesModulesesVO vO) {
        GroupesModuleses bean = new GroupesModuleses();
        BeanUtils.copyProperties(vO, bean);
        bean = groupesModulesesRepository.save(bean);
        return bean.getGroupesId();
    }

    public void delete(String id) {
        groupesModulesesRepository.deleteById(id);
    }

    public void update(String id, GroupesModulesesUpdateVO vO) {
        GroupesModuleses bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        groupesModulesesRepository.save(bean);
    }

    public GroupesModulesesDTO getById(String id) {
        GroupesModuleses original = requireOne(id);
        return toDTO(original);
    }

    public Page<GroupesModulesesDTO> query(GroupesModulesesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GroupesModulesesDTO toDTO(GroupesModuleses original) {
        GroupesModulesesDTO bean = new GroupesModulesesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private GroupesModuleses requireOne(String id) {
        return groupesModulesesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
