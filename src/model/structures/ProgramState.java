package model.structures;
import model.collections.dictionary.*;
import model.collections.heap.IHeap;
import model.collections.list.*;
import model.collections.stack.*;
import model.exceptions.ExpressionEvaluationException;
import model.exceptions.StatementExecutionException;
import model.statements.IStatement;
import model.values.IValue;
import model.values.StringValue;

import java.io.BufferedReader;

public class ProgramState {
    IStack<IStatement> executionStack;
    IDictionary<String, IValue> symbolTable;
    IList<IValue> outputStream;
    IDictionary<StringValue, BufferedReader> fileTable;
    IHeap heapTable;
    IStatement originalProgram;
    int id;
    static int latestID;

    public ProgramState(IStack<IStatement> exeStack, IDictionary<String, IValue> symTable, IList<IValue> out, IDictionary<StringValue, BufferedReader> fTable, IHeap heap, IStatement original){
        executionStack = exeStack;
        symbolTable = symTable;
        outputStream = out;
        fileTable = fTable;
        heapTable = heap;
        originalProgram = original;

        exeStack.push(originalProgram);

    }

    public ProgramState(IStack<IStatement> exeStack, IDictionary<String, IValue> symTable, IList<IValue> out, IDictionary<StringValue, BufferedReader> fTable, IHeap heap){
        executionStack = exeStack;
        symbolTable = symTable;
        outputStream = out;
        fileTable = fTable;
        heapTable = heap;

    }

    @Override
    public String toString(){
        return "ID: " + id + "\n"
                + "ExeStack: \n" + executionStack.toString() + "\n-------------\n\nSymbol Table: \n"
                + symbolTable.toString() + "\n-------------\n\nOutput Stream: \n"
                + outputStream.toString() + "\n-------------\n\nFile Table: \n"
                + fileTable.toString() + "\n-------------\n\nHeap Table: \n"
                + heapTable.toString() + "\n-------------\n\n";

    }

    public ProgramState runOneStep() throws StatementExecutionException, ExpressionEvaluationException {
        if(executionStack.isEmpty())
            throw new StatementExecutionException("ExecutionStack is empty");

        IStatement currentStatement = executionStack.pop();
        return currentStatement.execute(this);

    }


    public boolean isNotCompleted(){
        return !executionStack.isEmpty();

    }


    // Getters

    @SuppressWarnings("unused")
    public int getID(){
        return id;

    }

    @SuppressWarnings("unused")
    public IStack<IStatement> getExecutionStack(){
        return executionStack;

    }

    @SuppressWarnings("unused")
    public IDictionary<String, IValue> getSymbolTable(){
        return symbolTable;

    }

    public IList<IValue> getOutputStream(){
        return outputStream;

    }

    @SuppressWarnings("unused")
    public IDictionary<StringValue, BufferedReader> getFileTable(){
        return fileTable;

    }

    @SuppressWarnings("unused")
    public IHeap getHeapTable(){
        return heapTable;

    }

    @SuppressWarnings("unused")
    public IStatement getOriginalProgram(){
        return originalProgram;

    }


    // Setters

    @SuppressWarnings("unused")
    public static void initID(){
        latestID = -1;

    }

    @SuppressWarnings("unused")
    public void setID(){
        latestID++;
        this.id = latestID;

    }

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
    public void setFileTable(IDictionary<StringValue, BufferedReader> fTable){
        fileTable = fTable;

    }

    @SuppressWarnings("unused")
    public void setHeapTable(IHeap heap){
        heapTable = heap;

    }

    @SuppressWarnings("unused")
    public void setOriginalProgram(IStatement original){
        originalProgram = original;

    }

}
