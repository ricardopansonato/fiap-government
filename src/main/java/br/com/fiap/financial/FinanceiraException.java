
package br.com.fiap.financial;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "FinanceiraFaultException", targetNamespace = "http://servico.financeira.fiap.com.br/")
public class FinanceiraException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FinanceiraFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public FinanceiraException(String message, FinanceiraFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public FinanceiraException(String message, FinanceiraFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: br.com.fiap.financial.FinanceiraFault
     */
    public FinanceiraFault getFaultInfo() {
        return faultInfo;
    }

}