package cu.uci.grafanapp.services;

import cu.uci.grafanapp.entity.Registro;

import java.util.List;

public interface IRegistroService {
    public List<Registro> findAll();
    public Registro save(Registro registro);


}
