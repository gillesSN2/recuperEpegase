package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcFamillesParc2DTO;
import com.yewi.yewicore.recuperation.service.PrcFamillesParc2Service;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2QueryVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2UpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2VO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcFamillesParc2")
public class PrcFamillesParc2Controller {

    @Autowired
    private PrcFamillesParc2Service prcFamillesParc2Service;

    @PostMapping
    public String save(@Valid @RequestBody PrcFamillesParc2VO vO) {
        return prcFamillesParc2Service.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcFamillesParc2Service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcFamillesParc2UpdateVO vO) {
        prcFamillesParc2Service.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcFamillesParc2DTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcFamillesParc2Service.getById(id);
    }

    @GetMapping
    public Page<PrcFamillesParc2DTO> query(@Valid PrcFamillesParc2QueryVO vO) {
        return prcFamillesParc2Service.query(vO);
    }
}
