package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteExercicesVentesDTO;
import com.yewi.yewicore.recuperation.service.VteExercicesVentesService;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteExercicesVentesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteExercicesVentes")
public class VteExercicesVentesController {

    @Autowired
    private VteExercicesVentesService vteExercicesVentesService;

    @PostMapping
    public String save(@Valid @RequestBody VteExercicesVentesVO vO) {
        return vteExercicesVentesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteExercicesVentesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteExercicesVentesUpdateVO vO) {
        vteExercicesVentesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteExercicesVentesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteExercicesVentesService.getById(id);
    }

    @GetMapping
    public Page<VteExercicesVentesDTO> query(@Valid VteExercicesVentesQueryVO vO) {
        return vteExercicesVentesService.query(vO);
    }
}
