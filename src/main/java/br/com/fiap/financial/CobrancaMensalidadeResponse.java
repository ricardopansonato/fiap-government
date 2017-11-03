
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cobrancaMensalidadeResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cobrancaMensalidadeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultadoCobranca" type="{http://servico.financeira.fiap.com.br/}cobrancaMensalidadeResponsePojo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cobrancaMensalidadeResponse", propOrder = {
    "resultadoCobranca"
})
public class CobrancaMensalidadeResponse {

    protected CobrancaMensalidadeResponsePojo resultadoCobranca;

    /**
     * Obtem o valor da propriedade resultadoCobranca.
     * 
     * @return
     *     possible object is
     *     {@link CobrancaMensalidadeResponsePojo }
     *     
     */
    public CobrancaMensalidadeResponsePojo getResultadoCobranca() {
        return resultadoCobranca;
    }

    /**
     * Define o valor da propriedade resultadoCobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link CobrancaMensalidadeResponsePojo }
     *     
     */
    public void setResultadoCobranca(CobrancaMensalidadeResponsePojo value) {
        this.resultadoCobranca = value;
    }

}
