package cu.uci.grafanapp.controllers;

import cu.uci.grafanapp.entity.Registro;
import cu.uci.grafanapp.services.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistroRESTController {

    @Autowired
    private IRegistroService regServ;

    @GetMapping("/registros")
    public List<Registro> index(){
        return regServ.findAll();
    }

    @PostMapping ("/registrosC")
    public ResponseEntity<?> create(@RequestBody Registro registro) {
        // Cuando pasamos una referencia, o algo en formato json, utilizamos el
        // @RequestBody
        Registro registroNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            registroNew = regServ.save(registro);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El registro ha sido creado con éxito!");
        response.put("registro", registroNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
