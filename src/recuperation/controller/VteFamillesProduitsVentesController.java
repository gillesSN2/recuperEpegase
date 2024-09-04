package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteFamillesProduitsVentesDTO;
import com.yewi.yewicore.recuperation.service.VteFamillesProduitsVentesService;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteFamillesProduitsVentes")
public class VteFamillesProduitsVentesController {

    @Autowired
    private VteFamillesProduitsVentesService vteFamillesProduitsVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteFamillesProduitsVentesVO vO) {
        return vteFamillesProduitsVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteFamillesProduitsVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteFamillesProduitsVentesUpdateVO vO) {
        vteFamillesProduitsVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteFamillesProduitsVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteFamillesProduitsVentesService.getById(id);
    }

    @GetMapping
    public Page<VteFamillesProduitsVentesDTO> query(@Valid VteFamillesProduitsVentesQueryVO vO) {
        return vteFamillesProduitsVentesService.query(vO);
    }
}
