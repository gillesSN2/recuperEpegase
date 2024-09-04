package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPharmacieLigneDTO;
import com.yewi.yewicore.recuperation.service.MedPharmacieLigneService;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPharmacieLigne")
public class MedPharmacieLigneController {

    @Autowired
    private MedPharmacieLigneService medPharmacieLigneService;

    @PostMapping
    public String save(@Valid @RequestBody MedPharmacieLigneVO vO) {
        return medPharmacieLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPharmacieLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPharmacieLigneUpdateVO vO) {
        medPharmacieLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPharmacieLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPharmacieLigneService.getById(id);
    }

    @GetMapping
    public Page<MedPharmacieLigneDTO> query(@Valid MedPharmacieLigneQueryVO vO) {
        return medPharmacieLigneService.query(vO);
    }
}
