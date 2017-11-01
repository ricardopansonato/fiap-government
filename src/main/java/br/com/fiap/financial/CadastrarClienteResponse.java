
package br.com.fiap.financial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuario" type="{http://servico.financeira.fiap.com.br/}cadastroClienteResponsePojo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteResponse", propOrder = {
    "usuario"
})
public class CadastrarClienteResponse {

    protected CadastroClienteResponsePojo usuario;

    /**
     * Obtem o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link CadastroClienteResponsePojo }
     *     
     */
    public CadastroClienteResponsePojo getUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastroClienteResponsePojo }
     *     
     */
    public void setUsuario(CadastroClienteResponsePojo value) {
        this.usuario = value;
    }

}
