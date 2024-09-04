package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.EduElevesDTO;
import com.yewi.yewicore.recuperation.service.EduElevesService;
import com.yewi.yewicore.recuperation.vo.EduElevesQueryVO;
import com.yewi.yewicore.recuperation.vo.EduElevesUpdateVO;
import com.yewi.yewicore.recuperation.vo.EduElevesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/eduEleves")
public class EduElevesController {

    @Autowired
    private EduElevesService eduElevesService;

    @PostMapping
    public String save(@Valid @RequestBody EduElevesVO vO) {
        return eduElevesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        eduElevesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody EduElevesUpdateVO vO) {
        eduElevesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EduElevesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return eduElevesService.getById(id);
    }

    @GetMapping
    public Page<EduElevesDTO> query(@Valid EduElevesQueryVO vO) {
        return eduElevesService.query(vO);
    }
}
