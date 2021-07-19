package fr.eni.encheres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrator
 *
 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;
    private HashMap<Integer, String> errors;

    public BusinessException() {
        super();
        this.errors = new HashMap<Integer, String>();
    }

    /**
     *
     * @param code Code de l'erreur. Doit avoir un message associé dans un fichier properties.
     */
    public void ajouterErreur(int code, String message)
    {
        if(!this.errors.containsKey(code))
        {
            this.errors.put(code, message);
        }
    }

    public boolean hasErreurs()
    {
        return 0 < this.errors.size();
    }

    public HashMap<Integer, String> getErrors()
    {
        return this.errors;
    }


    public String[] getErrorMessages()
    {
    	ArrayList<String> errorMessages = new ArrayList<String>();
    	this.errors.forEach((code, message) -> errorMessages.add(message));
        return errorMessages.toArray(new String[errorMessages.size()]);
    }
}
