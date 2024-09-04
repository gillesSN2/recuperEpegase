package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedMotifEntreeDTO;
import com.yewi.yewicore.recuperation.service.MedMotifEntreeService;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medMotifEntree")
public class MedMotifEntreeController {

    @Autowired
    private MedMotifEntreeService medMotifEntreeService;

    @PostMapping
    public String save(@Valid @RequestBody MedMotifEntreeVO vO) {
        return medMotifEntreeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medMotifEntreeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedMotifEntreeUpdateVO vO) {
        medMotifEntreeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedMotifEntreeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medMotifEntreeService.getById(id);
    }

    @GetMapping
    public Page<MedMotifEntreeDTO> query(@Valid MedMotifEntreeQueryVO vO) {
        return medMotifEntreeService.query(vO);
    }
}
