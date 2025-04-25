package com.myapp.training_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "persons_cand")
public class PersonsCand {
    @Id
    @Column(name = "card_id", nullable = false)
    private Integer id;

    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Column(name = "tab_n", length = 7)
    private String tabN;

    @Column(name = "l_name", nullable = false, length = 30)
    private String lName;

    @Column(name = "f_name", length = 30)
    private String fName;

    @Column(name = "m_name", length = 30)
    private String mName;

    @Column(name = "full_name", length = 92)
    private String fullName;

    @Column(name = "full_name_io", length = 35)
    private String fullNameIo;

    @Column(name = "sex", length = 1)
    private String sex;

    @Column(name = "d_birth")
    private LocalDate dBirth;

    @Column(name = "inn", length = 15)
    private String inn;

    @Column(name = "snn", length = 15)
    private String snn;

    @Column(name = "d_from", nullable = false)
    private LocalDate dFrom;

    @Column(name = "appoint_id", nullable = false)
    private BigDecimal appointId;

    @Column(name = "appoint_name", nullable = false, length = 120)
    private String appointName;

    @Column(name = "categ_id", nullable = false)
    private BigDecimal categId;

    @Column(name = "categ_name", nullable = false, length = 44)
    private String categName;

    @Column(name = "d_in", nullable = false)
    private LocalDate dIn;

    @Column(name = "d_out", nullable = false)
    private LocalDate dOut;

    @Column(name = "dept_id", nullable = false)
    private BigDecimal deptId;

    @Column(name = "dept_name", nullable = false, length = 100)
    private String deptName;

    @Column(name = "dept_root_id")
    private BigDecimal deptRootId;

    @Column(name = "dept_root_name", length = 4000)
    private String deptRootName;

    @Column(name = "guid_1c", length = 1000)
    private String guid1c;

    @Column(name = "mdate")
    private LocalDate mdate;

    @Column(name = "plan_hours")
    private BigDecimal planHours;

    @Column(name = "fact_hours")
    private BigDecimal factHours;

    @Column(name = "actual_dept_root_id")
    private BigDecimal actualDeptRootId;

    @Column(name = "actual_dept_root_name", length = 4000)
    private String actualDeptRootName;

    @Column(name = "appoint_from")
    private LocalDate appointFrom;

    public Integer getId() {
        return id;
    }

    public Long getEmpId() {
        return empId;
    }

    public String getTabN() {
        return tabN;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullNameIo() {
        return fullNameIo;
    }

    public String getSex() {
        return sex;
    }

    public LocalDate getdBirth() {
        return dBirth;
    }

    public String getInn() {
        return inn;
    }

    public String getSnn() {
        return snn;
    }

    public LocalDate getdFrom() {
        return dFrom;
    }

    public BigDecimal getAppointId() {
        return appointId;
    }

    public String getAppointName() {
        return appointName;
    }

    public BigDecimal getCategId() {
        return categId;
    }

    public String getCategName() {
        return categName;
    }

    public LocalDate getdIn() {
        return dIn;
    }

    public LocalDate getdOut() {
        return dOut;
    }

    public BigDecimal getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public BigDecimal getDeptRootId() {
        return deptRootId;
    }

    public String getDeptRootName() {
        return deptRootName;
    }

    public String getGuid1c() {
        return guid1c;
    }

    public LocalDate getMdate() {
        return mdate;
    }

    public BigDecimal getPlanHours() {
        return planHours;
    }

    public BigDecimal getFactHours() {
        return factHours;
    }

    public BigDecimal getActualDeptRootId() {
        return actualDeptRootId;
    }

    public String getActualDeptRootName() {
        return actualDeptRootName;
    }

    public LocalDate getAppointFrom() {
        return appointFrom;
    }
}