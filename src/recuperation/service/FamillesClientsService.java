package recuperation.service;

import com.yewi.yewicore.recuperation.domain.FamillesClients;
import com.yewi.yewicore.recuperation.dtos.FamillesClientsDTO;
import com.yewi.yewicore.recuperation.repository.FamillesClientsRepository;
import com.yewi.yewicore.recuperation.vo.FamillesClientsQueryVO;
import com.yewi.yewicore.recuperation.vo.FamillesClientsUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamillesClientsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FamillesClientsService {

    @Autowired
    private FamillesClientsRepository famillesClientsRepository;

    public String save(FamillesClientsVO vO) {
        FamillesClients bean = new FamillesClients();
        BeanUtils.copyProperties(vO, bean);
        bean = famillesClientsRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        famillesClientsRepository.deleteById(id);
    }

    public void update(String id, FamillesClientsUpdateVO vO) {
        FamillesClients bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        famillesClientsRepository.save(bean);
    }

    public FamillesClientsDTO getById(String id) {
        FamillesClients original = requireOne(id);
        return toDTO(original);
    }

    public Page<FamillesClientsDTO> query(FamillesClientsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FamillesClientsDTO toDTO(FamillesClients original) {
        FamillesClientsDTO bean = new FamillesClientsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FamillesClients requireOne(String id) {
        return famillesClientsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
