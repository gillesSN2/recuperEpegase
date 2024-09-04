package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.FamillesClientsDTO;
import com.yewi.yewicore.recuperation.service.FamillesClientsService;
import com.yewi.yewicore.recuperation.vo.FamillesClientsQueryVO;
import com.yewi.yewicore.recuperation.vo.FamillesClientsUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamillesClientsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/famillesClients")
public class FamillesClientsController {

    @Autowired
    private FamillesClientsService famillesClientsService;

    @PostMapping
    public String save(@Valid @RequestBody FamillesClientsVO vO) {
        return famillesClientsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        famillesClientsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody FamillesClientsUpdateVO vO) {
        famillesClientsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FamillesClientsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return famillesClientsService.getById(id);
    }

    @GetMapping
    public Page<FamillesClientsDTO> query(@Valid FamillesClientsQueryVO vO) {
        return famillesClientsService.query(vO);
    }
}
