package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ModulesDTO;
import com.yewi.yewicore.recuperation.service.ModulesService;
import com.yewi.yewicore.recuperation.vo.ModulesQueryVO;
import com.yewi.yewicore.recuperation.vo.ModulesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ModulesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/modules")
public class ModulesController {

    @Autowired
    private ModulesService modulesService;

    @PostMapping
    public String save(@Valid @RequestBody ModulesVO vO) {
        return modulesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        modulesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ModulesUpdateVO vO) {
        modulesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ModulesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return modulesService.getById(id);
    }

    @GetMapping
    public Page<ModulesDTO> query(@Valid ModulesQueryVO vO) {
        return modulesService.query(vO);
    }
}
