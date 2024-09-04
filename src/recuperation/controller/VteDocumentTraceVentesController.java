package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteDocumentTraceVentesDTO;
import com.yewi.yewicore.recuperation.service.VteDocumentTraceVentesService;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteDocumentTraceVentes")
public class VteDocumentTraceVentesController {

    @Autowired
    private VteDocumentTraceVentesService vteDocumentTraceVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteDocumentTraceVentesVO vO) {
        return vteDocumentTraceVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteDocumentTraceVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteDocumentTraceVentesUpdateVO vO) {
        vteDocumentTraceVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteDocumentTraceVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteDocumentTraceVentesService.getById(id);
    }

    @GetMapping
    public Page<VteDocumentTraceVentesDTO> query(@Valid VteDocumentTraceVentesQueryVO vO) {
        return vteDocumentTraceVentesService.query(vO);
    }
}
