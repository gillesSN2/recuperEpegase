package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiCaissesMoisDTO;
import com.yewi.yewicore.recuperation.service.CaiCaissesMoisService;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiCaissesMois")
public class CaiCaissesMoisController {

    @Autowired
    private CaiCaissesMoisService caiCaissesMoisService;

    @PostMapping
    public String save(@Valid @RequestBody CaiCaissesMoisVO vO) {
        return caiCaissesMoisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiCaissesMoisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiCaissesMoisUpdateVO vO) {
        caiCaissesMoisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiCaissesMoisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiCaissesMoisService.getById(id);
    }

    @GetMapping
    public Page<CaiCaissesMoisDTO> query(@Valid CaiCaissesMoisQueryVO vO) {
        return caiCaissesMoisService.query(vO);
    }
}
