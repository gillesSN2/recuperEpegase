package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteTaxesVentesDTO;
import com.yewi.yewicore.recuperation.service.VteTaxesVentesService;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteTaxesVentes")
public class VteTaxesVentesController {

    @Autowired
    private VteTaxesVentesService vteTaxesVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteTaxesVentesVO vO) {
        return vteTaxesVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteTaxesVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteTaxesVentesUpdateVO vO) {
        vteTaxesVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteTaxesVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteTaxesVentesService.getById(id);
    }

    @GetMapping
    public Page<VteTaxesVentesDTO> query(@Valid VteTaxesVentesQueryVO vO) {
        return vteTaxesVentesService.query(vO);
    }
}
