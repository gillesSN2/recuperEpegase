package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmEquipesDTO;
import com.yewi.yewicore.recuperation.service.CmmEquipesService;
import com.yewi.yewicore.recuperation.vo.CmmEquipesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmEquipesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmEquipesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmEquipes")
public class CmmEquipesController {

    @Autowired
    private CmmEquipesService cmmEquipesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmEquipesVO vO) {
        return cmmEquipesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmEquipesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmEquipesUpdateVO vO) {
        cmmEquipesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmEquipesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmEquipesService.getById(id);
    }

    @GetMapping
    public Page<CmmEquipesDTO> query(@Valid CmmEquipesQueryVO vO) {
        return cmmEquipesService.query(vO);
    }
}
