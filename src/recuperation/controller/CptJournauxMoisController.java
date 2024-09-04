package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptJournauxMoisDTO;
import com.yewi.yewicore.recuperation.service.CptJournauxMoisService;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxMoisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptJournauxMois")
public class CptJournauxMoisController {

    @Autowired
    private CptJournauxMoisService cptJournauxMoisService;

    @PostMapping
    public String save(@Valid @RequestBody CptJournauxMoisVO vO) {
        return cptJournauxMoisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptJournauxMoisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptJournauxMoisUpdateVO vO) {
        cptJournauxMoisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptJournauxMoisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptJournauxMoisService.getById(id);
    }

    @GetMapping
    public Page<CptJournauxMoisDTO> query(@Valid CptJournauxMoisQueryVO vO) {
        return cptJournauxMoisService.query(vO);
    }
}
