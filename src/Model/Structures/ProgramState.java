package Model.Structures;
import Model.Collections.Dictionary.*;
import Model.Collections.List.*;
import Model.Collections.Stack.*;
import Model.Statements.IStatement;
import Model.Values.IValue;

public class ProgramState {
    IStack<IStatement> executionStack;
    IDictionary<String, IValue> symbolTable;
    IList<IValue> outputStream;
    IStatement originalProgram;

    public ProgramState(IStack<IStatement> exeStack, IDictionary<String, IValue> symTable, IList<IValue> out, IStatement original){
        executionStack = exeStack;
        symbolTable = symTable;
        outputStream = out;
        originalProgram = original;

        exeStack.push(originalProgram);

    }

    @Override
    public String toString(){
        return "ExeStack: \n" + executionStack.toString() + "\n-------------\n\nSymbol Table: \n"
                + symbolTable.toString() + "\n-------------\n\nOutput Stream: \n"
                + outputStream.toString() + "\n-------------\n";

    }


    // Getters

    @SuppressWarnings("unused")
    public IStack<IStatement> getExecutionStack(){
        return executionStack;

    }

    @SuppressWarnings("unused")
    public IDictionary<String, IValue> getSymbolTable(){
        return symbolTable;

    }

    @SuppressWarnings("unused")
    public IList<IValue> getOutputStream(){
        return outputStream;

    }

    @SuppressWarnings("unused")
    public IStatement getOriginalProgram(){
        return originalProgram;

    }


    // Setters

    @SuppressWarnings("unused")
    public void setExecutionStack(IStack<IStatement> exeStack){
        executionStack = exeStack;

    }

    @SuppressWarnings("unused")
    public void setSymbolTable(IDictionary<String, IValue> symTable){
        symbolTable = symTable;

    }

    @SuppressWarnings("unused")
    public void setOutputStream(IList<IValue> out){
        outputStream = out;

    }

    @SuppressWarnings("unused")
    public void setOriginalProgram(IStatement original){
        originalProgram = original;

    }

}
