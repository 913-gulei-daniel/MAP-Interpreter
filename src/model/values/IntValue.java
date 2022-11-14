package model.values;

import model.types.IType;
import model.types.IntType;

public class IntValue implements IValue{
    int value;

    public IntValue(int val){
        value = val;

    }

    public int getValue(){
        return value;

    }

    public String toString(){
        return Integer.toString(value);

    }

    @Override
    public IType getType() {
        return new IntType();

    }

}