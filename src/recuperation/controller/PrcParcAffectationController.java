package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcParcAffectationDTO;
import com.yewi.yewicore.recuperation.service.PrcParcAffectationService;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcParcAffectation")
public class PrcParcAffectationController {

    @Autowired
    private PrcParcAffectationService prcParcAffectationService;

    @PostMapping
    public String save(@Valid @RequestBody PrcParcAffectationVO vO) {
        return prcParcAffectationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcParcAffectationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcParcAffectationUpdateVO vO) {
        prcParcAffectationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcParcAffectationDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcParcAffectationService.getById(id);
    }

    @GetMapping
    public Page<PrcParcAffectationDTO> query(@Valid PrcParcAffectationQueryVO vO) {
        return prcParcAffectationService.query(vO);
    }
}
