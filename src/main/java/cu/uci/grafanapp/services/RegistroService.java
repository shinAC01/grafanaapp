package cu.uci.grafanapp.services;

import cu.uci.grafanapp.entity.Registro;
import cu.uci.grafanapp.repos.IRegistroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistroService implements IRegistroService{

    @Autowired
    private IRegistroRepo registroRepo;

    @Override
    @Transactional(readOnly=true)
    public List<Registro> findAll() {
        return (List<Registro>) registroRepo.findAll();
    }

    @Override
    @Transactional //esto es basicamente un comando para asegurar un poco
    //la consistencia y la integridad de los datos.
    public Registro save(Registro registro) {
        return registroRepo.save(registro);
    }
}
