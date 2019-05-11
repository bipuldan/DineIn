package com.cts.dinein.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.dinein.model.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

}
