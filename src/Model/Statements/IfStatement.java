package Model.Statements;

import Model.Exceptions.StatementExecutionException;
import Model.Expressions.IExpression;
import Model.Structures.ProgramState;

public class IfStatement implements IStatement{
    IExpression expr;
    IStatement thenStatement;
    IStatement elseStatement;

    public IfStatement(IExpression e, IStatement thenS, IStatement elseS){
        expr = e;
        thenStatement = thenS;
        elseStatement = elseS;

    }

    public String toString(){
        return "if(" + expr.toString() + ") then (" + thenStatement.toString() + ") else (" + elseStatement.toString() + "))";

    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementExecutionException {
        return null;

    }

}
