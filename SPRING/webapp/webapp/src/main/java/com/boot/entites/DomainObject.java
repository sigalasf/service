package com.boot.entites;

/**
 * Cette interface permet d avoir une base commune entre les classes User et Role
 */
public interface DomainObject {
    Integer getId();
    void setId(Integer id);
}
