package com.ravi.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// ========== Binding + Entity class ==============
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private Long phone;
	private Long ssn;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dob;
    private String activeSwitch;
    
    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate creationData;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getActiveSwitch() {
        return activeSwitch;
    }

    public void setActiveSwitch(String activeSwitch) {
        this.activeSwitch = activeSwitch;
    }

    public LocalDate getCreationData() {
        return creationData;
    }

    public void setCreationData(LocalDate creationData) {
        this.creationData = creationData;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", ssn=" + ssn
				+ ", dob=" + dob + ", activeSwitch=" + activeSwitch + ", creationData=" + creationData + ", updateDate="
				+ updateDate + "]";
	}
    
    
}
