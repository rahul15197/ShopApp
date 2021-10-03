/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

/**
 *
 * @author rahulmaheshwari
 */
public class ProductManagerException extends Exception{
    public ProductManagerException(){
        super();
    }
    public ProductManagerException(String message){
        super(message);
    }
    public ProductManagerException(String message, Throwable cause){
        super(message, cause);
    }
}
