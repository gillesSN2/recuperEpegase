package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiBonEntreeDTO;
import com.yewi.yewicore.recuperation.service.CaiBonEntreeService;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiBonEntree")
public class CaiBonEntreeController {

    @Autowired
    private CaiBonEntreeService caiBonEntreeService;

    @PostMapping
    public String save(@Valid @RequestBody CaiBonEntreeVO vO) {
        return caiBonEntreeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiBonEntreeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiBonEntreeUpdateVO vO) {
        caiBonEntreeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiBonEntreeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiBonEntreeService.getById(id);
    }

    @GetMapping
    public Page<CaiBonEntreeDTO> query(@Valid CaiBonEntreeQueryVO vO) {
        return caiBonEntreeService.query(vO);
    }
}
