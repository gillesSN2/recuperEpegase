package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteFactureLigneDTO;
import com.yewi.yewicore.recuperation.service.VteFactureLigneService;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteFactureLigne")
public class VteFactureLigneController {

    @Autowired
    private VteFactureLigneService vteFactureLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteFactureLigneVO vO) {
        return vteFactureLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteFactureLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteFactureLigneUpdateVO vO) {
        vteFactureLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteFactureLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteFactureLigneService.getById(id);
    }

    @GetMapping
    public Page<VteFactureLigneDTO> query(@Valid VteFactureLigneQueryVO vO) {
        return vteFactureLigneService.query(vO);
    }
}
