package demo.repository;

import demo.Device;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    Iterable<Device> findAll(Sort sort);
}
