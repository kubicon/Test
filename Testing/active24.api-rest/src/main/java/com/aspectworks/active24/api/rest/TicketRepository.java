package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.TicketEnt;
import com.aspectworks.active24.api.rest.vo.TicketVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TicketRepository extends JpaRepository<TicketEnt,Long>{

}
