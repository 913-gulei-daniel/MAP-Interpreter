package controller;
import model.collections.list.GenericList;
import model.collections.stack.IStack;
import model.exceptions.CollectionException;
import model.exceptions.ExpressionEvaluationException;
import model.exceptions.LoggingException;
import model.exceptions.StatementExecutionException;
import model.statements.IStatement;
import model.structures.GarbageCollector;
import model.structures.ProgramState;
import model.values.IValue;
import repository.Repository;

public class Controller {
    Repository repository;

    public Controller(Repository repo){
        repository = repo;

    }

    @SuppressWarnings("UnusedReturnValue")
    public ProgramState runOneStep(ProgramState state, boolean display) throws StatementExecutionException, ExpressionEvaluationException, CollectionException {
        IStack<IStatement> exeStack = state.getExecutionStack();

        if(exeStack.isEmpty())
            throw new StatementExecutionException("ExecutionStack is empty");

        IStatement currentStatement = exeStack.pop();
        currentStatement.execute(state);

        if(display)
            printProgramState(state);

        return state;

    }

    public void runAllSteps() throws StatementExecutionException, ExpressionEvaluationException, CollectionException, LoggingException {
        ProgramState progState = repository.getCurrentProgramState();
        repository.logProgramState();

        while(!progState.getExecutionStack().isEmpty()){
            runOneStep(progState, false);
            repository.logProgramState();

            progState.getHeapTable().setElems(GarbageCollector.collect(GarbageCollector.getAddressesFromSymbolTable(progState.getSymbolTable().getElems().values()), progState.getHeapTable().getElems()));
            repository.logProgramState();

            if(!progState.getOutputStream().isEmpty())
                printOutput();

        }

    }

    public ProgramState getCurrentProgramState(){
        return repository.getCurrentProgramState();

    }

    @SuppressWarnings("unused")
    public Repository getRepository(){
        return repository;

    }


    public void printOutput(){
        GenericList<IValue> out = (GenericList<IValue>) getCurrentProgramState().getOutputStream();

        for(IValue i : out){
            System.out.println(i.toString());

        }

        out.clear();

    }

    public void printProgramState(ProgramState state){
        System.out.println(state);

    }

}
