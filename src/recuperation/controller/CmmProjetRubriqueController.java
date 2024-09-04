package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProjetRubriqueDTO;
import com.yewi.yewicore.recuperation.service.CmmProjetRubriqueService;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetRubriqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProjetRubrique")
public class CmmProjetRubriqueController {

    @Autowired
    private CmmProjetRubriqueService cmmProjetRubriqueService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProjetRubriqueVO vO) {
        return cmmProjetRubriqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProjetRubriqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProjetRubriqueUpdateVO vO) {
        cmmProjetRubriqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProjetRubriqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProjetRubriqueService.getById(id);
    }

    @GetMapping
    public Page<CmmProjetRubriqueDTO> query(@Valid CmmProjetRubriqueQueryVO vO) {
        return cmmProjetRubriqueService.query(vO);
    }
}
