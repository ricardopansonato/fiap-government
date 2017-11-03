
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saldoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saldoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saldo" type="{http://servico.financeira.fiap.com.br/}saldoResponsePojo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saldoResponse", propOrder = {
    "saldo"
})
public class SaldoResponse {

    protected SaldoResponsePojo saldo;

    /**
     * Obtem o valor da propriedade saldo.
     * 
     * @return
     *     possible object is
     *     {@link SaldoResponsePojo }
     *     
     */
    public SaldoResponsePojo getSaldo() {
        return saldo;
    }

    /**
     * Define o valor da propriedade saldo.
     * 
     * @param value
     *     allowed object is
     *     {@link SaldoResponsePojo }
     *     
     */
    public void setSaldo(SaldoResponsePojo value) {
        this.saldo = value;
    }

}
