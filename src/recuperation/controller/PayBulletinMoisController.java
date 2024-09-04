package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayBulletinMoisDTO;
import com.yewi.yewicore.recuperation.service.PayBulletinMoisService;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payBulletinMois")
public class PayBulletinMoisController {

    @Autowired
    private PayBulletinMoisService payBulletinMoisService;

    @PostMapping
    public String save(@Valid @RequestBody PayBulletinMoisVO vO) {
        return payBulletinMoisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payBulletinMoisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayBulletinMoisUpdateVO vO) {
        payBulletinMoisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayBulletinMoisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payBulletinMoisService.getById(id);
    }

    @GetMapping
    public Page<PayBulletinMoisDTO> query(@Valid PayBulletinMoisQueryVO vO) {
        return payBulletinMoisService.query(vO);
    }
}
