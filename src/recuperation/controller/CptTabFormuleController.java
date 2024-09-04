package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptTabFormuleDTO;
import com.yewi.yewicore.recuperation.service.CptTabFormuleService;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptTabFormule")
public class CptTabFormuleController {

    @Autowired
    private CptTabFormuleService cptTabFormuleService;

    @PostMapping
    public String save(@Valid @RequestBody CptTabFormuleVO vO) {
        return cptTabFormuleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptTabFormuleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptTabFormuleUpdateVO vO) {
        cptTabFormuleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptTabFormuleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptTabFormuleService.getById(id);
    }

    @GetMapping
    public Page<CptTabFormuleDTO> query(@Valid CptTabFormuleQueryVO vO) {
        return cptTabFormuleService.query(vO);
    }
}
