package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptExercicesComptableDTO;
import com.yewi.yewicore.recuperation.service.CptExercicesComptableService;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableQueryVO;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptExercicesComptableVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptExercicesComptable")
public class CptExercicesComptableController {

    @Autowired
    private CptExercicesComptableService cptExercicesComptableService;

    @PostMapping
    public String save(@Valid @RequestBody CptExercicesComptableVO vO) {
        return cptExercicesComptableService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptExercicesComptableService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptExercicesComptableUpdateVO vO) {
        cptExercicesComptableService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptExercicesComptableDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptExercicesComptableService.getById(id);
    }

    @GetMapping
    public Page<CptExercicesComptableDTO> query(@Valid CptExercicesComptableQueryVO vO) {
        return cptExercicesComptableService.query(vO);
    }
}
