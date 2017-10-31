
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cobrancaMensalidadeRequestPojo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cobrancaMensalidadeRequestPojo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cobrancaMensalidadeRequestPojo", propOrder = {
    "cpfCnpj"
})
public class CobrancaMensalidadeRequestPojo {

    protected String cpfCnpj;

    /**
     * Obtém o valor da propriedade cpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o valor da propriedade cpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfCnpj(String value) {
        this.cpfCnpj = value;
    }

}
