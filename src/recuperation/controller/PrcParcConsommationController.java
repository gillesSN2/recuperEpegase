package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcParcConsommationDTO;
import com.yewi.yewicore.recuperation.service.PrcParcConsommationService;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcParcConsommation")
public class PrcParcConsommationController {

    @Autowired
    private PrcParcConsommationService prcParcConsommationService;

    @PostMapping
    public String save(@Valid @RequestBody PrcParcConsommationVO vO) {
        return prcParcConsommationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcParcConsommationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcParcConsommationUpdateVO vO) {
        prcParcConsommationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcParcConsommationDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcParcConsommationService.getById(id);
    }

    @GetMapping
    public Page<PrcParcConsommationDTO> query(@Valid PrcParcConsommationQueryVO vO) {
        return prcParcConsommationService.query(vO);
    }
}
