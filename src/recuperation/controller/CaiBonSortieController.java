package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiBonSortieDTO;
import com.yewi.yewicore.recuperation.service.CaiBonSortieService;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiBonSortie")
public class CaiBonSortieController {

    @Autowired
    private CaiBonSortieService caiBonSortieService;

    @PostMapping
    public String save(@Valid @RequestBody CaiBonSortieVO vO) {
        return caiBonSortieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiBonSortieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiBonSortieUpdateVO vO) {
        caiBonSortieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiBonSortieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiBonSortieService.getById(id);
    }

    @GetMapping
    public Page<CaiBonSortieDTO> query(@Valid CaiBonSortieQueryVO vO) {
        return caiBonSortieService.query(vO);
    }
}
