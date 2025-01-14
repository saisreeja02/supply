package com.wecp.progressive.repository;

import com.wecp.progressive.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    void deleteBySupplierId(@Param("supplierId") int supplierId);

    Supplier findBySupplierId(@Param("supplierId") int supplierId);
<<<<<<< HEAD

    Supplier findByUsername(String username);

    Supplier findByEmail(String email);
=======
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
}