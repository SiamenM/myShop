package com.maskalenchyk.shop.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -1034877392103899348L;
    Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
