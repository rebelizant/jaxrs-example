package io.github.rebelizant.jaxrsexample.persistence;

import java.util.Map;

interface Repository<T> {
    
    default Long nextId(Map<Long, T> data) {
        return data.keySet().stream().max((id1, id2) -> id1 > id2 ? 1 : id1 < id2 ? -1 : 0).orElse(0L) + 1L;
    }
    
}