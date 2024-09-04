package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcFamillesParc1DTO;
import com.yewi.yewicore.recuperation.service.PrcFamillesParc1Service;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1QueryVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1UpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1VO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcFamillesParc1")
public class PrcFamillesParc1Controller {

    @Autowired
    private PrcFamillesParc1Service prcFamillesParc1Service;

    @PostMapping
    public String save(@Valid @RequestBody PrcFamillesParc1VO vO) {
        return prcFamillesParc1Service.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcFamillesParc1Service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcFamillesParc1UpdateVO vO) {
        prcFamillesParc1Service.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcFamillesParc1DTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcFamillesParc1Service.getById(id);
    }

    @GetMapping
    public Page<PrcFamillesParc1DTO> query(@Valid PrcFamillesParc1QueryVO vO) {
        return prcFamillesParc1Service.query(vO);
    }
}
