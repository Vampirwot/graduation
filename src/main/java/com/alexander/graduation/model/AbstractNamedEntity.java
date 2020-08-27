package com.alexander.graduation.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    protected String name;

    protected AbstractNamedEntity() {
    }

    public AbstractNamedEntity(Long id,String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
