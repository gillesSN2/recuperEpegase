package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmPointDeVenteDTO;
import com.yewi.yewicore.recuperation.service.CmmPointDeVenteService;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPointDeVenteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmPointDeVente")
public class CmmPointDeVenteController {

    @Autowired
    private CmmPointDeVenteService cmmPointDeVenteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmPointDeVenteVO vO) {
        return cmmPointDeVenteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmPointDeVenteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmPointDeVenteUpdateVO vO) {
        cmmPointDeVenteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmPointDeVenteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmPointDeVenteService.getById(id);
    }

    @GetMapping
    public Page<CmmPointDeVenteDTO> query(@Valid CmmPointDeVenteQueryVO vO) {
        return cmmPointDeVenteService.query(vO);
    }
}
