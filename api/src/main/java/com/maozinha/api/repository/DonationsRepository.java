package com.maozinha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maozinha.api.domain.Donations;

public interface DonationsRepository extends JpaRepository<Donations, Long> {

}
