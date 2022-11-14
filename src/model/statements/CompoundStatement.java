package model.statements;

import model.collections.stack.IStack;
import model.structures.ProgramState;

@SuppressWarnings("unused")
public class CompoundStatement implements IStatement{
    IStatement first;
    IStatement second;

    public CompoundStatement(IStatement f, IStatement s){
        first = f;
        second = s;

    }

    public String toString(){
        return "(" + first.toString() + " " + second.toString() + ")";

    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<IStatement> exeStack = state.getExecutionStack();

        exeStack.push(second);
        exeStack.push(first);

        return state;

    }

    public IStatement getFirst() {
        return first;

    }

    public IStatement getSecond() {
        return second;

    }

}
