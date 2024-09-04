package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedLaboratoireLigneDTO;
import com.yewi.yewicore.recuperation.service.MedLaboratoireLigneService;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medLaboratoireLigne")
public class MedLaboratoireLigneController {

    @Autowired
    private MedLaboratoireLigneService medLaboratoireLigneService;

    @PostMapping
    public String save(@Valid @RequestBody MedLaboratoireLigneVO vO) {
        return medLaboratoireLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medLaboratoireLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedLaboratoireLigneUpdateVO vO) {
        medLaboratoireLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedLaboratoireLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medLaboratoireLigneService.getById(id);
    }

    @GetMapping
    public Page<MedLaboratoireLigneDTO> query(@Valid MedLaboratoireLigneQueryVO vO) {
        return medLaboratoireLigneService.query(vO);
    }
}
