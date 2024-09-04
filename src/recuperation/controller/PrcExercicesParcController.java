package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcExercicesParcDTO;
import com.yewi.yewicore.recuperation.service.PrcExercicesParcService;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcExercicesParcVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcExercicesParc")
public class PrcExercicesParcController {

    @Autowired
    private PrcExercicesParcService prcExercicesParcService;

    @PostMapping
    public String save(@Valid @RequestBody PrcExercicesParcVO vO) {
        return prcExercicesParcService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcExercicesParcService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcExercicesParcUpdateVO vO) {
        prcExercicesParcService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcExercicesParcDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcExercicesParcService.getById(id);
    }

    @GetMapping
    public Page<PrcExercicesParcDTO> query(@Valid PrcExercicesParcQueryVO vO) {
        return prcExercicesParcService.query(vO);
    }
}
