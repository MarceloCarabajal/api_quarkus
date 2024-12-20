package com.mcarabajal.repository;

import com.mcarabajal.entity.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterForReflection
public class CategoriaRepository implements PanacheRepository<Categoria> {
}
