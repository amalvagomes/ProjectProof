/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectproof;

import java.util.ArrayList;

/**
 * <p>A procedure is an Operation that has some code with it, stored in
 * <code>myInstructions</code>.</p>
 */
public class Procedure extends Operation {

    private ArrayList<Expression> myInstructions;
    
    /**
     * <p>Creates a new Procedure object from a string definition descriptor, 
     * a string requires descriptor, and a string ensures descriptor.</p>
     * @param def a String defining this Procedure
     * @param req a String defining what this Procedure requires.
     * @param ens a String describing what this Procedure ensures.
     * @see Operation
     */
    public Procedure(String def, String req, String ens)
    {
        super(def, req, ens);
        myInstructions = new ArrayList<Expression>();
    }

    /**
     * <p>Adds an instruction described by the String parameter to this
     * Procedure.  Requires that the instructions be in the order in which
     *   they are intended to be solved.</p>
     * @param ins a String describing an instruction
     */
    public void addInstruction(String ins)
    {
        myInstructions.add(new Expression(ins));
    }

    /**
     * <p>Returns a list of instructions in order of execution that defines
     *   this Procedure.</p>
     * @return an ArrayList of instructions, each represented as an Expression
     */
    public ArrayList<Expression> getInstructions()
    {
        ArrayList<Expression> retVal = new ArrayList<Expression>();
        for(Expression a : myInstructions)
        {
            retVal.add(a);
        }
        return retVal;
    }

    /**
     * <p>Creates an instance of ProofTable for this Procedure and returns it.
     * </p>
     * @return a ProofTable created with this Procedure's instructions
     */
    public ProofTable generateProofTable(){
        ProofTable p = new ProofTable();
        ProofTableState q;
        int stateCount = 0;
        String header = "State " + stateCount + "\n=======";
        Expression assumingE, confirmsE;
        assumingE.substitute(null);
        confirmsE.substitute(null);
        String assuming = "Assuming:\n" + assumingE.toString();
        String confirms = "Confirms:\n" + confirmsE.toString();
        p.addState()
        return p;
    }

    /**
     * <p>Converts this Procedure object into a string identical to the one
     * used to create it.</p>
     * @return a String representation of this Procedure
     */
    @Override
    public String toString()
    {
        String retVal = "Procedure " + super.getName() + "(";
        int commaCounter = 0;
        for(String a : super.getArgs())
        {
            retVal += a;
            if(commaCounter++ != super.getArgs().size()-1)
            {
                retVal += ", ";
            }
        }
        return retVal + ")";
    }

    @Override
    @SuppressWarnings({"EqualsWhichDoesntCheckParameterClass"})
    public boolean equals(Object o)
    {
        Procedure comp = (Procedure)o;
        return (this.toString().compareTo(comp.toString())==0);
    }
}
