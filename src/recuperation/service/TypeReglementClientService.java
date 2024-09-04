package recuperation.service;

import com.yewi.yewicore.recuperation.domain.TypeReglementClient;
import com.yewi.yewicore.recuperation.dtos.TypeReglementClientDTO;
import com.yewi.yewicore.recuperation.repository.TypeReglementClientRepository;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientQueryVO;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientUpdateVO;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TypeReglementClientService {

    @Autowired
    private TypeReglementClientRepository typeReglementClientRepository;

    public String save(TypeReglementClientVO vO) {
        TypeReglementClient bean = new TypeReglementClient();
        BeanUtils.copyProperties(vO, bean);
        bean = typeReglementClientRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        typeReglementClientRepository.deleteById(id);
    }

    public void update(String id, TypeReglementClientUpdateVO vO) {
        TypeReglementClient bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        typeReglementClientRepository.save(bean);
    }

    public TypeReglementClientDTO getById(String id) {
        TypeReglementClient original = requireOne(id);
        return toDTO(original);
    }

    public Page<TypeReglementClientDTO> query(TypeReglementClientQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TypeReglementClientDTO toDTO(TypeReglementClient original) {
        TypeReglementClientDTO bean = new TypeReglementClientDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private TypeReglementClient requireOne(String id) {
        return typeReglementClientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
