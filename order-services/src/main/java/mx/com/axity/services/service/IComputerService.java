package mx.com.axity.services.service;

import mx.com.axity.model.ComputerDO;

import java.util.List;
import java.util.Optional;

public interface IComputerService {

    public List<ComputerDO> findAll();

    public Optional<ComputerDO> findById(long computerId);

    public ComputerDO add(ComputerDO computer);

    public ComputerDO update(ComputerDO computer);

    public ComputerDO delete(ComputerDO computer);
}
