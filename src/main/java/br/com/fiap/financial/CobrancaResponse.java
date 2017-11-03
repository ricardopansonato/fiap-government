
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cobrancaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cobrancaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultadoCobranca" type="{http://servico.financeira.fiap.com.br/}cobrancaResponsePojo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cobrancaResponse", propOrder = {
    "resultadoCobranca"
})
public class CobrancaResponse {

    protected CobrancaResponsePojo resultadoCobranca;

    /**
     * Obtem o valor da propriedade resultadoCobranca.
     * 
     * @return
     *     possible object is
     *     {@link CobrancaResponsePojo }
     *     
     */
    public CobrancaResponsePojo getResultadoCobranca() {
        return resultadoCobranca;
    }

    /**
     * Define o valor da propriedade resultadoCobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link CobrancaResponsePojo }
     *     
     */
    public void setResultadoCobranca(CobrancaResponsePojo value) {
        this.resultadoCobranca = value;
    }

}
