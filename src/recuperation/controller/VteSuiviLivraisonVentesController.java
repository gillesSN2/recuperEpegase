package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteSuiviLivraisonVentesDTO;
import com.yewi.yewicore.recuperation.service.VteSuiviLivraisonVentesService;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteSuiviLivraisonVentes")
public class VteSuiviLivraisonVentesController {

    @Autowired
    private VteSuiviLivraisonVentesService vteSuiviLivraisonVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteSuiviLivraisonVentesVO vO) {
        return vteSuiviLivraisonVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteSuiviLivraisonVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteSuiviLivraisonVentesUpdateVO vO) {
        vteSuiviLivraisonVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteSuiviLivraisonVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteSuiviLivraisonVentesService.getById(id);
    }

    @GetMapping
    public Page<VteSuiviLivraisonVentesDTO> query(@Valid VteSuiviLivraisonVentesQueryVO vO) {
        return vteSuiviLivraisonVentesService.query(vO);
    }
}
