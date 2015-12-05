/**
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kaczmarzyk.spring.data.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * A simple entity for specification testing
 * 
 * @author Tomasz Kaczmarzyk
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private Gender gender;

    private String firstName;

    private String lastName;

    private String nickName;
    
    @Embedded
    private Address address = new Address();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;

    private Integer weight;
    
    private int weightInt;
    private long weightLong;
    
    private boolean gold;
    private Boolean goldObj;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Order> orders;
    
    
    public Customer() {
    }

    public Customer(String firstName, String lastName, Gender gender, Date registrationDate, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.registrationDate = registrationDate;
        this.address.setStreet(street);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

	public void setWeight(int weight) {
		this.weight = weight;
		this.weightInt = weight;
		this.weightLong = weight;
	}
	
	public boolean isGold() {
		return gold;
	}
	
	public void setGold(boolean gold) {
		this.gold = gold;
		this.goldObj = gold;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}

	public Collection<Order> getOrders() {
	    if (orders == null) {
	        orders = new ArrayList<>();
	    }
	    return orders;
	}
	
	@Override
	public String toString() {
		return "Customer[" + firstName + " " + lastName + "]";
	}
}
