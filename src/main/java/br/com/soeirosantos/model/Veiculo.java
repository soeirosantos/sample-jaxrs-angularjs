package br.com.soeirosantos.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@XmlRootElement
public class Veiculo implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column
   private String placa;

   @Column
   private String codigo;

   @Temporal(TemporalType.TIMESTAMP)
   private Date dtEntrada;

   @Column
   private Integer ano;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Veiculo) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getPlaca()
   {
      return this.placa;
   }

   public void setPlaca(final String placa)
   {
      this.placa = placa;
   }

   public String getCodigo()
   {
      return this.codigo;
   }

   public void setCodigo(final String codigo)
   {
      this.codigo = codigo;
   }

   public Date getDtEntrada()
   {
      return this.dtEntrada;
   }

   public void setDtEntrada(final Date dtEntrada)
   {
      this.dtEntrada = dtEntrada;
   }

   public Integer getAno()
   {
      return this.ano;
   }

   public void setAno(final Integer ano)
   {
      this.ano = ano;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (placa != null && !placa.trim().isEmpty())
         result += "placa: " + placa;
      if (codigo != null && !codigo.trim().isEmpty())
         result += ", codigo: " + codigo;
      if (ano != null)
         result += ", ano: " + ano;
      return result;
   }
}