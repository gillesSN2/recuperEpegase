package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteFormulesVentesDTO;
import com.yewi.yewicore.recuperation.service.VteFormulesVentesService;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteFormulesVentes")
public class VteFormulesVentesController {

    @Autowired
    private VteFormulesVentesService vteFormulesVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteFormulesVentesVO vO) {
        return vteFormulesVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteFormulesVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteFormulesVentesUpdateVO vO) {
        vteFormulesVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteFormulesVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteFormulesVentesService.getById(id);
    }

    @GetMapping
    public Page<VteFormulesVentesDTO> query(@Valid VteFormulesVentesQueryVO vO) {
        return vteFormulesVentesService.query(vO);
    }
}
