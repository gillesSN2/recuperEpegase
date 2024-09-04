package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptTabElementDTO;
import com.yewi.yewicore.recuperation.service.CptTabElementService;
import com.yewi.yewicore.recuperation.vo.CptTabElementQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabElementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabElementVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptTabElement")
public class CptTabElementController {

    @Autowired
    private CptTabElementService cptTabElementService;

    @PostMapping
    public String save(@Valid @RequestBody CptTabElementVO vO) {
        return cptTabElementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptTabElementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptTabElementUpdateVO vO) {
        cptTabElementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptTabElementDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptTabElementService.getById(id);
    }

    @GetMapping
    public Page<CptTabElementDTO> query(@Valid CptTabElementQueryVO vO) {
        return cptTabElementService.query(vO);
    }
}
