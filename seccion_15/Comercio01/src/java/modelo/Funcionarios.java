/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acidsulfurico
 */
@Entity
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f")
    , @NamedQuery(name = "Funcionarios.findById", query = "SELECT f FROM Funcionarios f WHERE f.id = :id")
    , @NamedQuery(name = "Funcionarios.findByNombre", query = "SELECT f FROM Funcionarios f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Funcionarios.findByApellido", query = "SELECT f FROM Funcionarios f WHERE f.apellido = :apellido")
    , @NamedQuery(name = "Funcionarios.findByCi", query = "SELECT f FROM Funcionarios f WHERE f.ci = :ci")
    , @NamedQuery(name = "Funcionarios.findByCargo", query = "SELECT f FROM Funcionarios f WHERE f.cargo = :cargo")
    , @NamedQuery(name = "Funcionarios.findBySueldo", query = "SELECT f FROM Funcionarios f WHERE f.sueldo = :sueldo")})
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "ci")
    private Integer ci;
    @Size(max = 45)
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "sueldo")
    private Integer sueldo;

    public Funcionarios() {
    }

    public Funcionarios(Integer id) {
        this.id = id;
    }

    public Funcionarios(Integer id, String nombre, String apellido, Integer ci, String cargo, Integer sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Funcionarios[ id=" + id + " ]";
    }
    
}
