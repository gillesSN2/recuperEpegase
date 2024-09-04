package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcMotifEntreeDTO;
import com.yewi.yewicore.recuperation.service.PrcMotifEntreeService;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcMotifEntree")
public class PrcMotifEntreeController {

    @Autowired
    private PrcMotifEntreeService prcMotifEntreeService;

    @PostMapping
    public String save(@Valid @RequestBody PrcMotifEntreeVO vO) {
        return prcMotifEntreeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcMotifEntreeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcMotifEntreeUpdateVO vO) {
        prcMotifEntreeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcMotifEntreeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcMotifEntreeService.getById(id);
    }

    @GetMapping
    public Page<PrcMotifEntreeDTO> query(@Valid PrcMotifEntreeQueryVO vO) {
        return prcMotifEntreeService.query(vO);
    }
}
