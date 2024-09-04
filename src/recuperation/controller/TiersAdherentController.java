package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.TiersAdherentDTO;
import com.yewi.yewicore.recuperation.service.TiersAdherentService;
import com.yewi.yewicore.recuperation.vo.TiersAdherentQueryVO;
import com.yewi.yewicore.recuperation.vo.TiersAdherentUpdateVO;
import com.yewi.yewicore.recuperation.vo.TiersAdherentVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tiersAdherent")
public class TiersAdherentController {

    @Autowired
    private TiersAdherentService tiersAdherentService;

    @PostMapping
    public String save(@Valid @RequestBody TiersAdherentVO vO) {
        return tiersAdherentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tiersAdherentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TiersAdherentUpdateVO vO) {
        tiersAdherentService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TiersAdherentDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tiersAdherentService.getById(id);
    }

    @GetMapping
    public Page<TiersAdherentDTO> query(@Valid TiersAdherentQueryVO vO) {
        return tiersAdherentService.query(vO);
    }
}
