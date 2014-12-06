/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByNameOfUser", query = "SELECT u FROM Users u WHERE u.nameOfUser = :nameOfUser"),
    @NamedQuery(name = "Users.findByImpRole", query = "SELECT u FROM Users u WHERE u.impRole = :impRole")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_pk_seq")
    @SequenceGenerator(name="users_pk_seq", sequenceName="users_pk_seq", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "NAME_OF_USER")
    private String nameOfUser;
    @Basic(optional = false)
    @Column(name = "IMP_ROLE")
    private Character impRole;
    @OneToMany(mappedBy = "deptMngrId")
    private Collection<Departments> departmentsCollection;
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    @ManyToOne
    private Departments deptId;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String password, String userName, Character impRole) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.impRole = impRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public Character getImpRole() {
        return impRole;
    }

    public void setImpRole(Character impRole) {
        this.impRole = impRole;
    }

    @XmlTransient
    public Collection<Departments> getDepartmentsCollection() {
        return departmentsCollection;
    }

    public void setDepartmentsCollection(Collection<Departments> departmentsCollection) {
        this.departmentsCollection = departmentsCollection;
    }

    public Departments getDeptId() {
        return deptId;
    }

    public void setDeptId(Departments deptId) {
        this.deptId = deptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.Users[ userId=" + userId + " ]";
    }
    
}
