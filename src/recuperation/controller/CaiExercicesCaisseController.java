package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiExercicesCaisseDTO;
import com.yewi.yewicore.recuperation.service.CaiExercicesCaisseService;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiExercicesCaisseVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiExercicesCaisse")
public class CaiExercicesCaisseController {

    @Autowired
    private CaiExercicesCaisseService caiExercicesCaisseService;

    @PostMapping
    public String save(@Valid @RequestBody CaiExercicesCaisseVO vO) {
        return caiExercicesCaisseService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiExercicesCaisseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiExercicesCaisseUpdateVO vO) {
        caiExercicesCaisseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiExercicesCaisseDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiExercicesCaisseService.getById(id);
    }

    @GetMapping
    public Page<CaiExercicesCaisseDTO> query(@Valid CaiExercicesCaisseQueryVO vO) {
        return caiExercicesCaisseService.query(vO);
    }
}
