package com.spring.integrate.hibernate.webservice;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
 
import javax.persistence.*;
import java.io.Serializable;
 
@Entity
@Table(name = "PLAYERS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Players implements Serializable {
 
    @Id
    @GeneratedValue(generator = "INCREMENT")
    @GenericGenerator(name = "INCREMENT", strategy = "INCREMENT")
    @Column(name = "ID")
    private Long id;
 
    @Column(name = "NAME")
    private String name;
 
    @Column(name = "AGE")
    private Integer age;
 
    @Column(name = "NICKNAME")
    private String nickName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNickName() {
		System.out.println("hello");
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
