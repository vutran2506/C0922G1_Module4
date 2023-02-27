package com.example.furama.repository.contract;

import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract ",nativeQuery = true)
    Page<Contract> findAllPageContract(Pageable pageable);

    @Query(value = "select c.* from contract c\n" +
            "where  c.start_date <= now() and now() <= c.end_date", nativeQuery = true)
    List<Contract> findAllContracting();



    @Query(value = "select (ifnull(f.cost,0) + ifnull(sum( af.cost * cd.quantity),0)) as total from `contract` c left join `contract_detail` cd on c.id = cd.contract_id left join `attach_facility` af on af.id = cd.attach_facility_id left join `facility` f on c.facility_id = f.id where c.id = :contractId group by c.id", nativeQuery = true)
    Double calculateTotal(@Param("contractId") int contractId);
}
