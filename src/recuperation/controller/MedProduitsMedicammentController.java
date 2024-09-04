package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedProduitsMedicammentDTO;
import com.yewi.yewicore.recuperation.service.MedProduitsMedicammentService;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medProduitsMedicamment")
public class MedProduitsMedicammentController {

    @Autowired
    private MedProduitsMedicammentService medProduitsMedicammentService;

    @PostMapping
    public String save(@Valid @RequestBody MedProduitsMedicammentVO vO) {
        return medProduitsMedicammentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medProduitsMedicammentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedProduitsMedicammentUpdateVO vO) {
        medProduitsMedicammentService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedProduitsMedicammentDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medProduitsMedicammentService.getById(id);
    }

    @GetMapping
    public Page<MedProduitsMedicammentDTO> query(@Valid MedProduitsMedicammentQueryVO vO) {
        return medProduitsMedicammentService.query(vO);
    }
}
