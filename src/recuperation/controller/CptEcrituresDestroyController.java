package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptEcrituresDestroyDTO;
import com.yewi.yewicore.recuperation.service.CptEcrituresDestroyService;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptEcrituresDestroy")
public class CptEcrituresDestroyController {

    @Autowired
    private CptEcrituresDestroyService cptEcrituresDestroyService;

    @PostMapping
    public String save(@Valid @RequestBody CptEcrituresDestroyVO vO) {
        return cptEcrituresDestroyService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptEcrituresDestroyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptEcrituresDestroyUpdateVO vO) {
        cptEcrituresDestroyService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptEcrituresDestroyDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptEcrituresDestroyService.getById(id);
    }

    @GetMapping
    public Page<CptEcrituresDestroyDTO> query(@Valid CptEcrituresDestroyQueryVO vO) {
        return cptEcrituresDestroyService.query(vO);
    }
}
