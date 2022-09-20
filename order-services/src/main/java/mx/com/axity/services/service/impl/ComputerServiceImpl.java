package mx.com.axity.services.service.impl;

import mx.com.axity.model.ComputerDO;
import mx.com.axity.persistence.ComputerDAO;
import mx.com.axity.services.service.IComputerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ComputerServiceImpl implements IComputerService {

    static final Logger LOG = LogManager.getLogger(ComputerServiceImpl.class);

    @Autowired
    ComputerDAO computerDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ComputerDO> findAll() {

        return computerDAO.findAll();
    }

    @Override
    public Optional<ComputerDO> findById(long computerId) {
        return Optional.empty();
    }

    @Override
    public ComputerDO add(ComputerDO computer) {
        return null;
    }

    @Override
    public ComputerDO update(ComputerDO computer) {
        return null;
    }

    @Override
    public ComputerDO delete(ComputerDO computer) {
        return null;
    }
}
