package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PointDeVentesDTO;
import com.yewi.yewicore.recuperation.service.PointDeVentesService;
import com.yewi.yewicore.recuperation.vo.PointDeVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.PointDeVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PointDeVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/pointDeVentes")
public class PointDeVentesController {

    @Autowired
    private PointDeVentesService pointDeVentesService;

    @PostMapping
    public String save(@Valid @RequestBody PointDeVentesVO vO) {
        return pointDeVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        pointDeVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PointDeVentesUpdateVO vO) {
        pointDeVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PointDeVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return pointDeVentesService.getById(id);
    }

    @GetMapping
    public Page<PointDeVentesDTO> query(@Valid PointDeVentesQueryVO vO) {
        return pointDeVentesService.query(vO);
    }
}
