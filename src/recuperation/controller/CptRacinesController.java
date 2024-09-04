package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptRacinesDTO;
import com.yewi.yewicore.recuperation.service.CptRacinesService;
import com.yewi.yewicore.recuperation.vo.CptRacinesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptRacinesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptRacinesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptRacines")
public class CptRacinesController {

    @Autowired
    private CptRacinesService cptRacinesService;

    @PostMapping
    public String save(@Valid @RequestBody CptRacinesVO vO) {
        return cptRacinesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptRacinesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptRacinesUpdateVO vO) {
        cptRacinesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptRacinesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptRacinesService.getById(id);
    }

    @GetMapping
    public Page<CptRacinesDTO> query(@Valid CptRacinesQueryVO vO) {
        return cptRacinesService.query(vO);
    }
}
