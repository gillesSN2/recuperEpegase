package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.StructuresDTO;
import com.yewi.yewicore.recuperation.service.StructuresService;
import com.yewi.yewicore.recuperation.vo.StructuresQueryVO;
import com.yewi.yewicore.recuperation.vo.StructuresUpdateVO;
import com.yewi.yewicore.recuperation.vo.StructuresVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/structures")
public class StructuresController {

    @Autowired
    private StructuresService structuresService;

    @PostMapping
    public String save(@Valid @RequestBody StructuresVO vO) {
        return structuresService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        structuresService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody StructuresUpdateVO vO) {
        structuresService.update(id, vO);
    }

    @GetMapping("/{id}")
    public StructuresDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return structuresService.getById(id);
    }

    @GetMapping
    public Page<StructuresDTO> query(@Valid StructuresQueryVO vO) {
        return structuresService.query(vO);
    }
}
