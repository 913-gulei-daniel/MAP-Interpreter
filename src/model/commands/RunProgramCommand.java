package model.commands;

import controller.Controller;
import model.exceptions.CollectionException;
import model.exceptions.ExpressionEvaluationException;
import model.exceptions.LoggingException;
import model.exceptions.StatementExecutionException;

public class RunProgramCommand extends Command{
    @SuppressWarnings("FieldMayBeFinal")
    private Controller controller;

    public RunProgramCommand(String k, String desc, Controller c){
        super(k, desc);
        controller = c;

    }

    @Override
    public void execute() {
        try{
            controller.runAllSteps();

        } catch (StatementExecutionException SEE) {
            System.out.println("Caught StatementExecutionException:");
            System.out.println(SEE.getMessage() + "\n");

        } catch (ExpressionEvaluationException EEE) {
            System.out.println("Caught ExpressionEvaluationException:");
            System.out.println(EEE.getMessage() + "\n");

        } catch (CollectionException CE) {
            System.out.println("Caught CollectionException");
            System.out.println(CE.getMessage() + "\n");

        } catch (LoggingException LE) {
            System.out.println("Caught LoggingException");
            System.out.println(LE.getMessage() + "\n");

        }

    }

}