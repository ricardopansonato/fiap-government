
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saldoResponsePojo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saldoResponsePojo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saldoResponsePojo", propOrder = {
    "saldo"
})
public class SaldoResponsePojo {

    protected double saldo;

    /**
     * Obtem o valor da propriedade saldo.
     * 
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o valor da propriedade saldo.
     * 
     */
    public void setSaldo(double value) {
        this.saldo = value;
    }

}
