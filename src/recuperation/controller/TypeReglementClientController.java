package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.TypeReglementClientDTO;
import com.yewi.yewicore.recuperation.service.TypeReglementClientService;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientQueryVO;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientUpdateVO;
import com.yewi.yewicore.recuperation.vo.TypeReglementClientVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/typeReglementClient")
public class TypeReglementClientController {

    @Autowired
    private TypeReglementClientService typeReglementClientService;

    @PostMapping
    public String save(@Valid @RequestBody TypeReglementClientVO vO) {
        return typeReglementClientService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        typeReglementClientService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TypeReglementClientUpdateVO vO) {
        typeReglementClientService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TypeReglementClientDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return typeReglementClientService.getById(id);
    }

    @GetMapping
    public Page<TypeReglementClientDTO> query(@Valid TypeReglementClientQueryVO vO) {
        return typeReglementClientService.query(vO);
    }
}
